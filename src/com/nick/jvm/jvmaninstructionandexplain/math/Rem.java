package com.nick.jvm.jvmaninstructionandexplain.math;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Rem {
    public static class IREM extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value1 = jvmFrame.jvmOperandStack.popInt();
            int value2 = jvmFrame.jvmOperandStack.popInt();

            jvmFrame.jvmOperandStack.pushInt(value1 % value2);
        }
    }

    public static class DREM extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            double value1 = jvmFrame.jvmOperandStack.popDouble();
            double value2 = jvmFrame.jvmOperandStack.popDouble();

            jvmFrame.jvmOperandStack.pushDouble(value1 % value2);//TODO 应该不是正确值
        }
    }

    public static class FREM extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            float value1 = jvmFrame.jvmOperandStack.popFloat();
            float value2 = jvmFrame.jvmOperandStack.popFloat();

            jvmFrame.jvmOperandStack.pushFloat(value1 % value2);//TODO 应该不是正确值
        }
    }


    public static class LREM extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            long value1 = jvmFrame.jvmOperandStack.popLong();
            long value2 = jvmFrame.jvmOperandStack.popLong();

            jvmFrame.jvmOperandStack.pushLong(value1 % value2);
        }
    }
}
