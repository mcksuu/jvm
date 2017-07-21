package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class ConstantFieldrefInfo extends CpInfo {
    private U2 classIndex;
    private U2 nameNndTypeIndex;

    public ConstantFieldrefInfo() {
        this.tag = CONSTANT_FIELDREF_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        classIndex = U2.read(inputStream);
        nameNndTypeIndex = U2.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantFieldRefInfo{" + "classIndex=" + classIndex.getValue() + ", nameAndTypeIndex="
                + nameNndTypeIndex.getValue() + '}';
    }
}
