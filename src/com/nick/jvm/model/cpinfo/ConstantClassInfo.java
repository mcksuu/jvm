package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class ConstantClassInfo extends CpInfo {

    private U2 nameIndex;

    public ConstantClassInfo() {
        this.tag = CONSTANT_CLASS_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        nameIndex = U2.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantClassInfo{" + "index=" + nameIndex.getValue() + '}';
    }

    public short getIndex() {
        return nameIndex.getValue();
    }
}
