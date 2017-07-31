package com.nick.jvm.jvmaninstructionandexplain.comparisons;


import com.nick.jvm.jvmaninstructionandexplain.instruction.BranchInstruction;
import com.nick.jvm.jvmaninstructionandexplain.BranchLogic;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Ifcond {
    public static class IFEQ extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = jvmFrame.jvmOperandStack.popInt();
            if (value == 0) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IFNE extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = jvmFrame.jvmOperandStack.popInt();
            if (value != 0) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IFLT extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = jvmFrame.jvmOperandStack.popInt();
            if (value < 0) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IFLE extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = jvmFrame.jvmOperandStack.popInt();
            if (value <= 0) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IFGT extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = jvmFrame.jvmOperandStack.popInt();
            if (value > 0) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IFGE extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = jvmFrame.jvmOperandStack.popInt();
            if (value >= 0) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }
}
