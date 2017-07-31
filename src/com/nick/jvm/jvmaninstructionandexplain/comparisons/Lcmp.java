package com.nick.jvm.jvmaninstructionandexplain.comparisons;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Lcmp {
    public static class LCMP extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            long value2 = jvmFrame.jvmOperandStack.popLong();
            long value1 = jvmFrame.jvmOperandStack.popLong();

            if (value2 > value1) {
                jvmFrame.jvmOperandStack.pushInt(1);
            } else if (value2 < value1) {
                jvmFrame.jvmOperandStack.pushInt(-1);
            } else {
                jvmFrame.jvmOperandStack.pushInt(0);
            }


        }
    }
}
