package com.nick.jvm.jvmaninstructionandexplain.conversions;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class D2x {
    public static class D2F extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            float value = (float) jvmFrame.jvmOperandStack.popDouble();
            jvmFrame.jvmOperandStack.pushFloat(value);
        }
    }

    public static class D2I extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = (int) jvmFrame.jvmOperandStack.popDouble();
            jvmFrame.jvmOperandStack.pushInt(value);
        }
    }

    public static class D2L extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            long value = (long) jvmFrame.jvmOperandStack.popDouble();
            jvmFrame.jvmOperandStack.pushLong(value);
        }
    }
}
