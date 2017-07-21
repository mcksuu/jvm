package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class ConstantInvokeDynamicInfo extends CpInfo {

    private U2 bootstrapMethodAttrIndex;
    private U2 nameAndTypeIndex;

    public ConstantInvokeDynamicInfo() {
        tag = CONSTANT_INVOKEDYNAMIC_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        bootstrapMethodAttrIndex = U2.read(inputStream);
        nameAndTypeIndex = U2.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantInvokeDynamicInfo{" + "bootstrapMethodAttrIndex=" + bootstrapMethodAttrIndex.getValue()
                + ", nameAndTypeIndex=" + nameAndTypeIndex.getValue() + '}';
    }
}
