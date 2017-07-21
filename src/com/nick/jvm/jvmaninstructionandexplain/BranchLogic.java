package com.nick.jvm.jvmaninstructionandexplain;

import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class BranchLogic {
    public static void branch(JvmFrame jvmFrame, int offset) {
        int pc = jvmFrame.jvmThread.pc;
        jvmFrame.setNextPc(pc + offset);
    }
}
