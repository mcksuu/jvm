package com.nick.jvm.jvmaninstructionandexplain.constants;

import com.nick.jvm.jvmaninstructionandexplain.instruction.BaseInstruction;
import com.nick.jvm.jvmaninstructionandexplain.instruction.JvmBytecodeReader;
import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.model.type.U1;
import com.nick.jvm.model.type.U2;

/**
 * Created by KangShuai on 2017/7/19.
 */
public class Ipush {
    public static class BIPUSH extends BaseInstruction {
        private U1 u1 ;
        @Override
        public void fetchOperands(JvmBytecodeReader jvmBytecodeReader) {
            u1 = jvmBytecodeReader.readInt8();
        }

        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushInt(u1.getValue());
        }
    }

    public static class SIPUSH extends BaseInstruction{
        private U2 u2 ;
        @Override
        public void fetchOperands(JvmBytecodeReader jvmBytecodeReader) {
            u2 = jvmBytecodeReader.readUint16();
        }

        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushInt(u2.getValue());
        }
    }
}
