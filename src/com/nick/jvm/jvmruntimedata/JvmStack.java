package com.nick.jvm.jvmruntimedata;

/**
 * Created by KangShuai on 2017/7/18.
 */
public class JvmStack {
    private int maxSize;
    private int size;
    private JvmFrame topFrame;

    public JvmStack(int maxSize, int size) {
        this.maxSize = maxSize;
        this.size = size;
    }

    public JvmStack push(JvmFrame jvmFrame) {
        if (size >= maxSize) {
            throw new RuntimeException("java.lang.StackOverflowError");
        } else {
            if (topFrame != null) {
                jvmFrame.lowerFrame = topFrame;
            }
            topFrame = jvmFrame;
            size++;
            return this;
        }

    }

    public JvmFrame pop() {
        if (topFrame == null) {
            throw new RuntimeException("jvm stack is empty!");
        }

        JvmFrame jvmFrame = topFrame;
        topFrame = jvmFrame.lowerFrame;
        jvmFrame.lowerFrame = null;
        size--;
        return jvmFrame;
    }

    public JvmFrame top() {
        if (topFrame == null) {
            throw new RuntimeException("jvm stack is empty!");
        } else {
            return topFrame;
        }
    }
}
