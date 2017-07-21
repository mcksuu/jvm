package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U4;

import java.io.InputStream;


public class ConstantFloatInfo extends CpInfo {

    private U4 bytes;

    public ConstantFloatInfo() {
        tag = CONSTANT_INTEGER_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        bytes = U4.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantFloatInfo{" + "bytes=" + bytes.getValue() + '}';
    }
}
