package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U4;

import java.io.InputStream;


public class ConstantDoubleInfo extends CpInfo {

    private U4 hightBytes;
    private U4 lowBytes;

    public ConstantDoubleInfo() {
        tag = CONSTANT_DOUBLE_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        hightBytes = U4.read(inputStream);
        lowBytes = U4.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantDoubleInfo{" + "hightBytes=" + hightBytes.getValue() + " lowBytes = " + lowBytes.getValue()
                + "doubleValue = " + Double.longBitsToDouble(
                        (((hightBytes.getValue() & 0xffffffffL) << 32) | lowBytes.getValue() & 0xffffffffL))
                + '}';
    }
}
