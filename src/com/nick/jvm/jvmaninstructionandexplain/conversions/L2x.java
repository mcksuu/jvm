package com.nick.jvm.jvmaninstructionandexplain.conversions;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class L2x {
    public static class L2F extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            float value = (float) jvmFrame.jvmOperandStack.popLong();
            jvmFrame.jvmOperandStack.pushFloat(value);
        }
    }

    public static class L2I extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = (int) jvmFrame.jvmOperandStack.popLong();
            jvmFrame.jvmOperandStack.pushInt(value);
        }
    }

    public static class L2D extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            double value = (double) jvmFrame.jvmOperandStack.popLong();
            jvmFrame.jvmOperandStack.pushDouble(value);
        }
    }
}
