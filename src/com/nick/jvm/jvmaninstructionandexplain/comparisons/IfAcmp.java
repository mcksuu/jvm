package com.nick.jvm.jvmaninstructionandexplain.comparisons;

import com.nick.jvm.jvmaninstructionandexplain.instruction.BranchInstruction;
import com.nick.jvm.jvmaninstructionandexplain.BranchLogic;
import com.nick.jvm.jvmobj.JvmObject;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class IfAcmp {
    public static class IF_ACMPEQ extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmObject value1 = jvmFrame.jvmOperandStack.popRef();
            JvmObject value2 = jvmFrame.jvmOperandStack.popRef();
            if (value1 == value2) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }

    public static class IF_ACMPNE extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmObject value1 = jvmFrame.jvmOperandStack.popRef();
            JvmObject value2 = jvmFrame.jvmOperandStack.popRef();
            if (value1 != value2) {
                BranchLogic.branch(jvmFrame, offset.getValue());
            }
        }
    }
}
