package com.nick.jvm.jvmaninstructionandexplain.loads;

import com.nick.jvm.jvmaninstructionandexplain.instruction.Index8Instruction;
import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmobj.JvmObject;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Load {

    public static class ALOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            aLoad(jvmFrame, index);
        }
    }

    public static class ALOAD_0 extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            aLoad(jvmFrame, 0);
        }
    }

    public static class ALOAD_1 extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            aLoad(jvmFrame, 1);
        }
    }

    public static class ALOAD_2 extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            aLoad(jvmFrame, 2);
        }
    }

    public static class ALOAD_3 extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            aLoad(jvmFrame, 3);
        }
    }


    public static class ILOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, index);
        }
    }

    public static class ILOAD_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, 0);
        }
    }

    public static class ILOAD_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, 1);
        }
    }

    public static class ILOAD_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, 2);
        }
    }

    public static class ILOAD_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, 3);
        }
    }

    public static class DLOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, index);
        }
    }

    public static class DLOAD_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, 0);
        }
    }

    public static class DLOAD_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, 1);
        }
    }

    public static class DLOAD_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, 2);
        }
    }

    public static class DLOAD_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, 3);
        }
    }

    public static class FLOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, index);
        }
    }

    public static class FLOAD_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, 0);
        }
    }

    public static class FLOAD_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, 1);
        }
    }

    public static class FLOAD_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, 2);
        }
    }

    public static class FLOAD_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, 3);
        }
    }

    public static class LLOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, index);
        }
    }

    public static class LLOAD_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, 0);
        }
    }

    public static class LLOAD_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, 1);
        }
    }

    public static class LLOAD_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, 2);
        }
    }

    public static class LLOAD_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, 3);
        }
    }

    public static void iLoad(JvmFrame jvmFrame, int index) {
        int value = jvmFrame.jvmLocalVars.getInt(index);
        jvmFrame.jvmOperandStack.pushInt(value);
    }

    private static void aLoad(JvmFrame jvmFrame, int index) {
        JvmObject value = jvmFrame.jvmLocalVars.getRef(index);
        jvmFrame.jvmOperandStack.pushRef(value);
    }

    public static void dLoad(JvmFrame jvmFrame, int index) {
        double value = jvmFrame.jvmLocalVars.getDouble(index);
        jvmFrame.jvmOperandStack.pushDouble(value);
    }

    public static void fLoad(JvmFrame jvmFrame, int index) {
        float value = jvmFrame.jvmLocalVars.getFloat(index);
        jvmFrame.jvmOperandStack.pushFloat(value);
    }

    public static void lLoad(JvmFrame jvmFrame, int index) {
        long value = jvmFrame.jvmLocalVars.getLong(index);
        jvmFrame.jvmOperandStack.pushLong(value);
    }
}
