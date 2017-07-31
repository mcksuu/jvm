package com.nick.jvm.jvmaninstructionandexplain.comparisons;

import com.nick.jvm.jvmaninstructionandexplain.instruction.BranchInstruction;
import com.nick.jvm.jvmaninstructionandexplain.BranchLogic;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class IfIcmp {
    public static class IF_ICMPEQ extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value2 = jvmFrame.jvmOperandStack.popInt();
            int value1 = jvmFrame.jvmOperandStack.popInt();
            if (value1 == value2) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IF_ICMPNE extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value2 = jvmFrame.jvmOperandStack.popInt();
            int value1 = jvmFrame.jvmOperandStack.popInt();
            if (value1 != value2) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IF_ICMPLT extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value2 = jvmFrame.jvmOperandStack.popInt();
            int value1 = jvmFrame.jvmOperandStack.popInt();
            if (value1 < value2) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IF_ICMPLE extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value2 = jvmFrame.jvmOperandStack.popInt();
            int value1 = jvmFrame.jvmOperandStack.popInt();
            if (value1 <= value2) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IF_ICMPGT extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value2 = jvmFrame.jvmOperandStack.popInt();
            int value1 = jvmFrame.jvmOperandStack.popInt();
            if (value1 > value2) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IF_ICMPGE extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            int value2 = jvmFrame.jvmOperandStack.popInt();
            int value1 = jvmFrame.jvmOperandStack.popInt();
            if (value1 >= value2) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }
}
