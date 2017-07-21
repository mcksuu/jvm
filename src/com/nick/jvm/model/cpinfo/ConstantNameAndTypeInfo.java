package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class ConstantNameAndTypeInfo extends CpInfo {

    private U2 nameIndex;
    private U2 descriptorIndex;

    public ConstantNameAndTypeInfo() {
        tag = CONSTANT_NAMEANDTYPE_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        nameIndex = U2.read(inputStream);
        descriptorIndex = U2.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantNameAndTypeInfo{" + "nameIndex=" + nameIndex.getValue() + ", descriptorIndex="
                + descriptorIndex.getValue() + '}';
    }
}
