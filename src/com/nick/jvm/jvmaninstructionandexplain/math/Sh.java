package com.nick.jvm.jvmaninstructionandexplain.math;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.jvmruntimedata.JvmOperandStack;

/**
 * 位移
 * Created by KangShuai on 2017/7/21.
 */
public class Sh {
    public static class ISHL extends NoOperandsInstruction {// int左位移

        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmOperandStack jvmOperandStack = jvmFrame.jvmOperandStack;
            int value2 = jvmOperandStack.popInt();
            int value1 = jvmOperandStack.popInt();
            int s = value2 & 0x1f;
            jvmOperandStack.pushInt(value1 << s);
        }
    }

    public static class ISHR extends NoOperandsInstruction {// int算术右位移

        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmOperandStack jvmOperandStack = jvmFrame.jvmOperandStack;
            int value2 = jvmOperandStack.popInt();
            int value1 = jvmOperandStack.popInt();
            int s = value2 & 0x1f;
            jvmOperandStack.pushInt(value1 >> s);
        }
    }

    public static class IUSHR extends NoOperandsInstruction {// int逻辑右位移

        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmOperandStack jvmOperandStack = jvmFrame.jvmOperandStack;
            int value2 = jvmOperandStack.popInt();
            int value1 = jvmOperandStack.popInt();
            int s = value2 & 0x1f;
            jvmOperandStack.pushInt(value1 >>> s);
        }
    }

    public static class LSHL extends NoOperandsInstruction {// long左位移

        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmOperandStack jvmOperandStack = jvmFrame.jvmOperandStack;
            long value2 = jvmOperandStack.popLong();
            long value1 = jvmOperandStack.popLong();
            long s = value2 & 0x3f;
            jvmOperandStack.pushLong(value1 << s);
        }
    }

    public static class LSHR extends NoOperandsInstruction {// long算术右位移

        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmOperandStack jvmOperandStack = jvmFrame.jvmOperandStack;
            long value2 = jvmOperandStack.popLong();
            long value1 = jvmOperandStack.popLong();
            long s = value2 & 0x3f;
            jvmOperandStack.pushLong(value1 >> s);
        }
    }

    public static class LUSHR extends NoOperandsInstruction {// long逻辑右位移

        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmOperandStack jvmOperandStack = jvmFrame.jvmOperandStack;
            long value2 = jvmOperandStack.popLong();
            long value1 = jvmOperandStack.popLong();
            long s = value2 & 0x3f;
            jvmOperandStack.pushLong(value1 >>> s);
        }
    }
}
