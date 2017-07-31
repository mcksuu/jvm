package com.nick.jvm.jvmaninstructionandexplain.conversions;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class F2x {
    public static class F2D extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            double value = (double) jvmFrame.jvmOperandStack.popFloat();
            jvmFrame.jvmOperandStack.pushDouble(value);
        }
    }

    public static class F2I extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = (int) jvmFrame.jvmOperandStack.popFloat();
            jvmFrame.jvmOperandStack.pushInt(value);
        }
    }

    public static class F2L extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            long value = (long) jvmFrame.jvmOperandStack.popFloat();
            jvmFrame.jvmOperandStack.pushLong(value);
        }
    }
}
