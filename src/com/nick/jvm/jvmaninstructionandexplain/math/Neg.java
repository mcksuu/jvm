package com.nick.jvm.jvmaninstructionandexplain.math;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Neg {
    public static class INEG extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value1 = jvmFrame.jvmOperandStack.popInt();

            jvmFrame.jvmOperandStack.pushInt(-value1);
        }
    }

    public static class DNEG extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            double value1 = jvmFrame.jvmOperandStack.popDouble();

            jvmFrame.jvmOperandStack.pushDouble(-value1);
        }
    }

    public static class FNEG extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            float value1 = jvmFrame.jvmOperandStack.popFloat();

            jvmFrame.jvmOperandStack.pushFloat(-value1);
        }
    }


    public static class LNEG extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            long value1 = jvmFrame.jvmOperandStack.popLong();

            jvmFrame.jvmOperandStack.pushLong(-value1);
        }
    }
}
