package com.nick.jvm.jvmaninstructionandexplain;

import com.nick.jvm.jvmaninstructionandexplain.instruction.JvmBytecodeReader;
import com.nick.jvm.jvmaninstructionandexplain.instruction.JvmInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.jvmruntimedata.JvmThread;
import com.nick.jvm.model.attributeinfo.BaseAttributeinfo;
import com.nick.jvm.model.attributeinfo.CodeAttribute;
import com.nick.jvm.model.methodinfo.MethodInfo;
import com.nick.jvm.model.type.U1;
import sun.invoke.util.BytecodeDescriptor;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Interpreter {

    public static void interpret(MethodInfo methodInfo) {
        BaseAttributeinfo[] attributeinfos = methodInfo.attributeinfos;
        CodeAttribute codeAttribute = null;
        for (int i = 0; i < attributeinfos.length; i++) {
            if (attributeinfos[i] instanceof CodeAttribute) {
                codeAttribute = (CodeAttribute) attributeinfos[i];
                break;
            }
        }

        if (codeAttribute != null) {
            int maxLocals = codeAttribute.maxLocals.getValue();
            int maxStack = codeAttribute.maxStack.getValue();


            U1[] codes = codeAttribute.code;
            byte[] byteCodes = new byte[codes.length];

            for (int i = 0; i < codes.length; i++) {
                byteCodes[i] = codes[i].getValue();
            }

            JvmThread jvmThread = new JvmThread();
            JvmFrame jvmFrame = jvmThread.newJvmFrame(maxLocals, maxStack);
            jvmThread.pushFrame(jvmFrame);
            loop(jvmThread, byteCodes);
        }
    }

    private static void loop(JvmThread jvmThread, byte[] byteCodes) {
        JvmFrame jvmFrame = jvmThread.popFrame();
        JvmBytecodeReader reader = new JvmBytecodeReader();
        while (true) {
            int pc = jvmFrame.nextPc;
            jvmThread.pc = pc;
            reader.reset(byteCodes, pc);
            byte opCode = reader.readInt8().getValue();
            JvmInstruction jvmInstruction = InstructionFactory.newInstance(opCode);
            jvmInstruction.fetchOperands(reader);
            jvmFrame.setNextPc(reader.pc);
            System.out.println("pc = " + pc + "\t" + jvmInstruction.getClass().getName() + " jvmLocalVars = " + jvmFrame.jvmLocalVars + " jvmOperandStack = " + jvmFrame.jvmOperandStack);
            jvmInstruction.execute(jvmFrame);
        }
    }
}
