package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U1;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class ConstantMethodHandleInfo extends CpInfo {

    private U1 referenceKind;
    private U2 referenceIndex;

    public ConstantMethodHandleInfo() {
        tag = CONSTANT_METHODHANDLE_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        referenceKind = U1.read(inputStream);
        referenceIndex = U2.read(inputStream);
    }

    @Override
    public String toString() {
        return "ConstantMethodHandleInfo{" + "referenceKind=" + referenceKind.getValue() + ", referenceIndex="
                + referenceIndex.getValue() + '}';
    }
}
