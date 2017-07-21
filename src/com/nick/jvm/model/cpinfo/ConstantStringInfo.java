package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class ConstantStringInfo extends CpInfo {

    private U2 stringIndex;

    public ConstantStringInfo() {
        tag = CONSTANT_STRING_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        stringIndex = U2.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantStringInfo{" + "index=" + stringIndex.getValue() + '}';
    }
}
