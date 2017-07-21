package com.nick.jvm.jvmaninstructionandexplain.stack;

import com.nick.jvm.jvmaninstructionandexplain.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.jvmruntimedata.JvmOperandStack;
import com.nick.jvm.jvmruntimedata.JvmSlot;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Swap {
    public static class SWAP extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmOperandStack jvmOperandStack = jvmFrame.jvmOperandStack;
            JvmSlot jvmSlot1 = jvmOperandStack.popSlot();
            JvmSlot jvmSlot2 = jvmOperandStack.popSlot();
            jvmOperandStack.pushSlot(jvmSlot1);
            jvmOperandStack.pushSlot(jvmSlot2);
        }
    }
}
