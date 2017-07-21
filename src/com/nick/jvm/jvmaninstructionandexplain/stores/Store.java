package com.nick.jvm.jvmaninstructionandexplain.stores;

import com.nick.jvm.jvmaninstructionandexplain.Index8Instruction;
import com.nick.jvm.jvmaninstructionandexplain.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Store {
    public static class aSTORE extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            aStore(jvmFrame, index);
        }
    }

    public static class ISTORE extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iStore(jvmFrame, index);
        }
    }

    public static class ISTORE_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iStore(jvmFrame, 0);
        }
    }

    public static class ISTORE_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iStore(jvmFrame, 1);
        }
    }

    public static class ISTORE_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iStore(jvmFrame, 2);
        }
    }

    public static class ISTORE_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iStore(jvmFrame, 3);
        }
    }

    public static class DSTORE extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dStore(jvmFrame, index);
        }
    }

    public static class DSTORE_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dStore(jvmFrame, 0);
        }
    }

    public static class DSTORE_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dStore(jvmFrame, 1);
        }
    }

    public static class DSTORE_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dStore(jvmFrame, 2);
        }
    }

    public static class DSTORE_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dStore(jvmFrame, 3);
        }
    }

    public static class FSTORE extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fStore(jvmFrame, index);
        }
    }

    public static class FSTORE_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fStore(jvmFrame, 0);
        }
    }

    public static class FSTORE_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fStore(jvmFrame, 1);
        }
    }

    public static class FSTORE_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fStore(jvmFrame, 2);
        }
    }

    public static class FSTORE_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fStore(jvmFrame, 3);
        }
    }

    public static class LSTORE extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lStore(jvmFrame, index);
        }
    }

    public static class LSTORE_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lStore(jvmFrame, 0);
        }
    }

    public static class LSTORE_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lStore(jvmFrame, 1);
        }
    }

    public static class LSTORE_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lStore(jvmFrame, 2);
        }
    }

    public static class LSTORE_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lStore(jvmFrame, 3);
        }
    }

    public static void aStore(JvmFrame jvmFrame, int index) {
        jvmFrame.jvmLocalVars.setRef(index, jvmFrame.jvmOperandStack.popRef());
    }

    public static void iStore(JvmFrame jvmFrame, int index) {
        jvmFrame.jvmLocalVars.setInt(index, jvmFrame.jvmOperandStack.popInt());
    }

    public static void dStore(JvmFrame jvmFrame, int index) {
        jvmFrame.jvmLocalVars.setDouble(index, jvmFrame.jvmOperandStack.popDouble());
    }

    public static void fStore(JvmFrame jvmFrame, int index) {
        jvmFrame.jvmLocalVars.setFloat(index, jvmFrame.jvmOperandStack.popFloat());
    }

    public static void lStore(JvmFrame jvmFrame, int index) {
        jvmFrame.jvmLocalVars.setLong(index, jvmFrame.jvmOperandStack.popLong());
    }
}
