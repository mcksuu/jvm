package com.nick.jvm.jvmaninstructionandexplain.comparisons;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Fcmp {
    public static class FCMPG extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fcmp(jvmFrame, true);
        }
    }

    public static class FCMPL extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fcmp(jvmFrame, false);
        }
    }

    private static void fcmp(JvmFrame frame, boolean gFlag) {
        float value2 = frame.jvmOperandStack.popFloat();
        float value1 = frame.jvmOperandStack.popFloat();
        if (value2 > value2) {
            frame.jvmOperandStack.pushInt(1);
        } else if (value2 == value2) {
            frame.jvmOperandStack.pushInt(0);
        } else if (value2 < value1) {
            frame.jvmOperandStack.pushInt(-1);
        } else if (gFlag) {
            frame.jvmOperandStack.pushInt(1);
        } else {
            frame.jvmOperandStack.pushInt(-1);
        }
    }
}
