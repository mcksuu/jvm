package com.nick.jvm.jvmruntimedata;

/**
 * Created by KangShuai on 2017/7/18.
 */
public class JvmFrame {
    public JvmFrame lowerFrame;
    public JvmLocalVars jvmLocalVars;
    public JvmOperandStack jvmOperandStack;
    public JvmThread jvmThread;
    public int nextPc;

    public JvmFrame(JvmThread jvmThread,int maxLocals,int maxStack) {
        this.jvmThread = jvmThread;
        jvmLocalVars = new JvmLocalVars(maxLocals);
        jvmOperandStack = new JvmOperandStack(maxStack);
    }

    public void setNextPc(int nextPc) {

    }
}
