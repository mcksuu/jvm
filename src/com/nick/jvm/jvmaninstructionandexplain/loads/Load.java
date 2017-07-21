package com.nick.jvm.jvmaninstructionandexplain.loads;

import com.nick.jvm.jvmaninstructionandexplain.Index8Instruction;
import com.nick.jvm.jvmaninstructionandexplain.NoOperandsInstruction;
import com.nick.jvm.jvmobj.JvmObject;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Load {

    public class ALOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            aLoad(jvmFrame, index);
        }
    }


    public class ILOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, index);
        }
    }

    public class ILOAD_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, 0);
        }
    }

    public class ILOAD_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, 1);
        }
    }

    public class ILOAD_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, 2);
        }
    }

    public class ILOAD_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            iLoad(jvmFrame, 3);
        }
    }

    public class DLOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, index);
        }
    }

    public class DLOAD_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, 0);
        }
    }

    public class DLOAD_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, 1);
        }
    }

    public class DLOAD_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, 2);
        }
    }

    public class DLOAD_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            dLoad(jvmFrame, 3);
        }
    }

    public class FLOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, index);
        }
    }

    public class FLOAD_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, 0);
        }
    }

    public class FLOAD_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, 1);
        }
    }

    public class FLOAD_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, 2);
        }
    }

    public class FLOAD_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            fLoad(jvmFrame, 3);
        }
    }

    public class LLOAD extends Index8Instruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, index);
        }
    }

    public class LLOAD_0 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, 0);
        }
    }

    public class LLOAD_1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, 1);
        }
    }

    public class LLOAD_2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, 2);
        }
    }

    public class LLOAD_3 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            lLoad(jvmFrame, 3);
        }
    }

    public void iLoad(JvmFrame jvmFrame, int index) {
        int value = jvmFrame.jvmLocalVars.getInt(index);
        jvmFrame.jvmOperandStack.pushInt(value);
    }

    private void aLoad(JvmFrame jvmFrame, int index) {
        JvmObject value = jvmFrame.jvmLocalVars.getRef(index);
        jvmFrame.jvmOperandStack.pushRef(value);
    }

    public void dLoad(JvmFrame jvmFrame, int index) {
        double value = jvmFrame.jvmLocalVars.getDouble(index);
        jvmFrame.jvmOperandStack.pushDouble(value);
    }

    public void fLoad(JvmFrame jvmFrame, int index) {
        float value = jvmFrame.jvmLocalVars.getFloat(index);
        jvmFrame.jvmOperandStack.pushFloat(value);
    }

    public void lLoad(JvmFrame jvmFrame, int index) {
        long value = jvmFrame.jvmLocalVars.getLong(index);
        jvmFrame.jvmOperandStack.pushLong(value);
    }
}
