package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class ConstantMethodTypeInfo extends CpInfo {

    private U2 descriptorIndex;

    public ConstantMethodTypeInfo() {
        tag = CONSTANT_METHODTYPE_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        descriptorIndex = U2.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantMethodTypeInfo{" + "descriptorIndex=" + descriptorIndex.getValue() + '}';
    }
}
