package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U4;

import java.io.InputStream;


public class ConstantLongInfo extends CpInfo {

    private U4 hightBytes;
    private U4 lowBytes;

    public ConstantLongInfo() {
        tag = CONSTANT_LONG_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        hightBytes = U4.read(inputStream);
        lowBytes = U4.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantLongInfo{" + "hightBytes=" + hightBytes.getValue() + " lowBytes = " + lowBytes.getValue()
                + "longValue = " + (((hightBytes.getValue() & 0xffffffff) << 32) | lowBytes.getValue()) + '}';
    }
}
