package com.nick.jvm.jvmaninstructionandexplain.control;

import com.nick.jvm.jvmaninstructionandexplain.instruction.BranchInstruction;
import com.nick.jvm.jvmaninstructionandexplain.BranchLogic;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Goto {
    public static class GOTO extends BranchInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            BranchLogic.branch(jvmFrame, offset.getValue());
        }
    }
}
