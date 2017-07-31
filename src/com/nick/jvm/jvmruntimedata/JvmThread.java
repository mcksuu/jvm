package com.nick.jvm.jvmruntimedata;

/**
 * Created by KangShuai on 2017/7/18.
 */
public class JvmThread {

    public int pc;
    public JvmStack jvmStack;

    public JvmThread() {
        jvmStack = new JvmStack(1024, 0);
    }

    public JvmThread(int pc, JvmStack jvmStack) {
        this.pc = pc;
        this.jvmStack = jvmStack;
    }

    public JvmFrame newJvmFrame(int maxLocals, int maxStack) {
        return new JvmFrame(this, maxLocals, maxStack);
    }

    public void pushFrame(JvmFrame jvmFrame) {
        jvmStack.push(jvmFrame);
    }

    public JvmFrame popFrame() {
        return jvmStack.pop();
    }
}
