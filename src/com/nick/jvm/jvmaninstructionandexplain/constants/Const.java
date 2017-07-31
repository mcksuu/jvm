package com.nick.jvm.jvmaninstructionandexplain.constants;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/19.
 */
public class Const {

    public static class ACONST_NULL extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushRef(null);
        }
    }

    public static class DCONST_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushDouble(0.0d);
        }
    }

    public static class DCONST_1 extends NoOperandsInstruction {

        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushDouble(1.0d);
        }
    }

    public static class FCONST_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushFloat(0.0f);
        }
    }

    public static class FCONST_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushFloat(1.0f);
        }
    }

    public static class FCONST_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushFloat(2.0f);
        }
    }

    public static class ICONST_M1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushInt(-1);
        }
    }

    public static class ICONST_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushInt(0);
        }
    }

    public static class ICONST_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushInt(1);
        }
    }

    public static class ICONST_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushInt(2);
        }
    }

    public static class ICONST_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushInt(3);
        }
    }

    public static class ICONST_4 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushInt(4);
        }
    }

    public static class ICONST_5 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushInt(5);
        }
    }

    public static class LCONST_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushLong(0L);
        }
    }

    public static class LCONST_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.pushLong(1L);
        }
    }
}

