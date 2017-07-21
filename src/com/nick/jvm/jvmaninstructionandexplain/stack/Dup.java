package com.nick.jvm.jvmaninstructionandexplain.stack;

import com.nick.jvm.jvmaninstructionandexplain.NoOperandsInstruction;
import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.jvmruntimedata.JvmOperandStack;
import com.nick.jvm.jvmruntimedata.JvmSlot;

/**
 * 复制栈顶的变量
 * Created by KangShuai on 2017/7/21.
 */
public class Dup {
    public static class DUP extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmSlot jvmSlot = jvmFrame.jvmOperandStack.popSlot();
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot);
        }
    }

    //复制操作数栈栈顶的值，并将此值压入到操作数栈顶以下2个值之后。
    public static class DUP_X1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmSlot jvmSlot = jvmFrame.jvmOperandStack.popSlot();
            JvmSlot jvmSlot2 = jvmFrame.jvmOperandStack.popSlot();
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot2);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot);
        }
    }

    /**
     * 复制操作数栈栈顶的值，并插入到栈顶以下2个或3个值之后
     * 格式 dup_x2
     * 结构 dup_x2 = 91（0x5b）
     * 操作数栈
     * 结构1：
     * „，value3，value2，value1 →
     * „，value1，value3，value2，value1
     * 当value1、value2和value3都是§2.11.1的表2.3中列出的分类一中的数据类型时满足结构1。
     * 结构2：
     * „，value2，value1 →
     * „，value1，value2，value1
     * 当value1是§2.11.1的表2.3中列出的分类一中的数据类型，而value2是分类二的数据类型时满足结构2。
     * 描述
     * 复制操作数栈栈顶的值，并将此值压入到操作数栈顶以下2个或3个值之后。
     * 并没有检查类型
     */
    public static class DUP_X2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmOperandStack jvmOperandStack = jvmFrame.jvmOperandStack;
            JvmSlot jvmSlot1 = jvmOperandStack.popSlot();
            JvmSlot jvmSlot2 = jvmOperandStack.popSlot();
            JvmSlot jvmSlot3 = jvmOperandStack.popSlot();
            jvmOperandStack.pushSlot(jvmSlot1);
            jvmOperandStack.pushSlot(jvmSlot2);
            jvmOperandStack.pushSlot(jvmSlot3);
            jvmOperandStack.pushSlot(jvmSlot1);
        }
    }

    /**
     * 操作
     * 复制操作数栈栈顶1个或2个值，并插入到栈顶
     * 格式 dup2
     * 结构
     * dup2 = 92（0x5c）
     * 操作数栈
     * 结构1：
     * „，value2，value1 →
     * „，value2，value1，value2，value1
     * 当value1和value2都是§2.11.1的表2.3中列出的分类一中的数据类型时满足结构1。
     * 结构2：
     * „，value →
     * „，value，value
     * 当value是§2.11.1的表2.3中列出的分类二中的数据类型时满足结构2。
     * 描述
     * 复制操作数栈栈顶1个或2个值，并将这些值按照原来的顺序压入到操作数栈顶
     */
    public static class DUP2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmSlot jvmSlot1 = jvmFrame.jvmOperandStack.popSlot();
            JvmSlot jvmSlot2 = jvmFrame.jvmOperandStack.popSlot();
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot2);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot1);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot2);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot1);
        }
    }

    public static class DUP2_X1 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmSlot jvmSlot1 = jvmFrame.jvmOperandStack.popSlot();
            JvmSlot jvmSlot2 = jvmFrame.jvmOperandStack.popSlot();
            JvmSlot jvmSlot3 = jvmFrame.jvmOperandStack.popSlot();
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot2);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot1);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot3);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot2);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot1);
        }
    }

    public static class DUP2_X2 extends NoOperandsInstruction {
        @Override
        public void execute(JvmFrame jvmFrame) {
            JvmSlot jvmSlot1 = jvmFrame.jvmOperandStack.popSlot();
            JvmSlot jvmSlot2 = jvmFrame.jvmOperandStack.popSlot();
            JvmSlot jvmSlot3 = jvmFrame.jvmOperandStack.popSlot();
            JvmSlot jvmSlot4 = jvmFrame.jvmOperandStack.popSlot();
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot2);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot1);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot4);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot3);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot2);
            jvmFrame.jvmOperandStack.pushSlot(jvmSlot1);
        }
    }
}
