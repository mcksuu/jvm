package com.nick.jvm.jvmaninstructionandexplain;

import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.jvmruntimedata.JvmThread;
import com.nick.jvm.model.attributeinfo.BaseAttributeinfo;
import com.nick.jvm.model.attributeinfo.CodeAttribute;
import com.nick.jvm.model.methodinfo.MethodInfo;
import com.nick.jvm.model.type.U1;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Interpreter {

    public void interpret(MethodInfo methodInfo) {
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
        }
    }
}
