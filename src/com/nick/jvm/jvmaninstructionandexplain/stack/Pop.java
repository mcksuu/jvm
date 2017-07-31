package com.nick.jvm.jvmaninstructionandexplain.stack;

import com.nick.jvm.jvmaninstructionandexplain.instruction.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * pop和pop2指令将栈
 * 顶变量弹出
 * Created by KangShuai on 2017/7/21.
 */
public class Pop {
    public static class POP extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.popSlot();
        }
    }

    public static class POP2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            jvmFrame.jvmOperandStack.popSlot();
            jvmFrame.jvmOperandStack.popSlot();
        }
    }
}
