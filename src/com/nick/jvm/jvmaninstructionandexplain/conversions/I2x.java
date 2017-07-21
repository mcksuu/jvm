package com.nick.jvm.jvmaninstructionandexplain.conversions;

import com.nick.jvm.jvmaninstructionandexplain.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class I2x {
    public static class I2F extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            float value = (float) jvmFrame.jvmOperandStack.popInt();
            jvmFrame.jvmOperandStack.pushFloat(value);
        }
    }

    public static class I2D extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            double value = (double) jvmFrame.jvmOperandStack.popInt();
            jvmFrame.jvmOperandStack.pushDouble(value);
        }
    }

    public static class D2L extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            long value = (long) jvmFrame.jvmOperandStack.popInt();
            jvmFrame.jvmOperandStack.pushLong(value);
        }
    }
}
