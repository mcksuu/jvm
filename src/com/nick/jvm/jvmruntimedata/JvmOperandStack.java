package com.nick.jvm.jvmruntimedata;

import com.nick.jvm.jvmobj.JvmObject;

/**
 * Created by KangShuai on 2017/7/19.
 */
public class JvmOperandStack {

    public int size;
    public JvmSlot[] jvmSlots;

    public JvmOperandStack(int maxStack) {
        if (maxStack > 0) {
            jvmSlots = new JvmSlot[maxStack];
            for (int i = 0; i < jvmSlots.length; i++) {
                jvmSlots[i] = new JvmSlot();
            }
        }
    }

    public void pushInt(int value) {
        jvmSlots[size].value = value;
        size++;
    }

    public int popInt() {
        size--;
        return jvmSlots[size].value;
    }

    public void pushFloat(float value) {
        jvmSlots[size].value = Float.floatToIntBits(value);
        size++;
    }

    public float popFloat() {
        size--;
        return Float.intBitsToFloat(jvmSlots[size].value);
    }

    public void pushLong(long value) {
        jvmSlots[size].value = (int) (value >> 32);//高
        jvmSlots[size + 1].value = (int) value;//低
        size += 2;
    }

    public long popLong() {
        size -= 2;
        long height = (jvmSlots[size].value & 0x000000ffffffffL) << 32;
        long low = jvmSlots[size + 1].value & 0x00000000ffffffffL;
        return height | low;
    }

    public void pushDouble(double value) {
        pushLong(Double.doubleToLongBits(value));
    }

    public double popDouble() {
        return Double.longBitsToDouble(popLong());
    }

    public void pushRef(JvmObject value) {
        jvmSlots[size].ref = value;
        size++;
    }

    public JvmObject popRef() {
        size--;

        JvmObject ref = jvmSlots[size].ref;
        jvmSlots[size].ref = null;
        return ref;
    }

    public void pushSlot(JvmSlot slot) {
        jvmSlots[size] = slot;
        size++;
    }

    public JvmSlot popSlot() {
        size--;
        return jvmSlots[size];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (JvmSlot jvmSlot : jvmSlots) {
            stringBuilder.append(jvmSlot.toString() + " ");
        }
        stringBuilder.append("size = " + size);
        return stringBuilder.toString();
    }
}
