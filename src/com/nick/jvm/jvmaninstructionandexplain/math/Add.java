package com.nick.jvm.jvmaninstructionandexplain.math;

import com.nick.jvm.jvmaninstructionandexplain.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Add {
    public static class IADD extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value1 = jvmFrame.jvmOperandStack.popInt();
            int value2 = jvmFrame.jvmOperandStack.popInt();
            jvmFrame.jvmOperandStack.pushInt(value1 + value2);
        }
    }

    public static class DADD extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            double value1 = jvmFrame.jvmOperandStack.popDouble();
            double value2 = jvmFrame.jvmOperandStack.popDouble();
            jvmFrame.jvmOperandStack.pushDouble(value1 + value2);
        }
    }

    public static class FADD extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            float value1 = jvmFrame.jvmOperandStack.popFloat();
            float value2 = jvmFrame.jvmOperandStack.popFloat();
            jvmFrame.jvmOperandStack.pushFloat(value1 + value2);
        }
    }

    public static class LADD extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            long value1 = jvmFrame.jvmOperandStack.popLong();
            long value2 = jvmFrame.jvmOperandStack.popLong();
            jvmFrame.jvmOperandStack.pushLong(value1 + value2);
        }
    }
}
