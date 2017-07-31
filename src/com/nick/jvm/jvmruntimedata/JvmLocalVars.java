package com.nick.jvm.jvmruntimedata;

import com.nick.jvm.jvmobj.JvmObject;

/**
 * Created by KangShuai on 2017/7/19.
 */
public class JvmLocalVars {
    public JvmSlot[] jvmSlots;

    public JvmLocalVars(int maxLocals) {
        if (maxLocals > 0) {
            jvmSlots = new JvmSlot[maxLocals];
            for (int i = 0; i < jvmSlots.length; i++) {
                jvmSlots[i] = new JvmSlot();
            }
        }
    }

    public void setInt(int index, int value) {
        jvmSlots[index].value = value;
    }

    public int getInt(int index) {
        return jvmSlots[index].value;
    }

    public void setFloat(int index, float value) {
        jvmSlots[index].value = Float.floatToIntBits(value);
    }

    public float getFloat(int index) {
        return Float.intBitsToFloat(jvmSlots[index].value);
    }

    public void setLong(int index, long value) {
        jvmSlots[index].value = (int) (value >> 32);//高位
        jvmSlots[index + 1].value = (int) value;//低位
    }

    public long getLong(int index) {
        long height = (((long) jvmSlots[index].value) & 0x000000ffffffffL) << 32;
        long low = ((long) jvmSlots[index + 1].value) & 0x00000000ffffffffL;
        return height | low;
    }

    public void setDouble(int index, double value) {
        long longBits = Double.doubleToLongBits(value);
        setLong(index, longBits);
    }

    public double getDouble(int index) {
        return Double.longBitsToDouble(getLong(index));
    }

    public void setRef(int index, JvmObject jvmObject) {
        jvmSlots[index].ref = jvmObject;
    }

    public JvmObject getRef(int index) {
        return jvmSlots[index].ref;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (JvmSlot jvmSlot : jvmSlots) {
            stringBuilder.append(jvmSlot.toString() + " ");
        }
        return stringBuilder.toString();
    }
}
