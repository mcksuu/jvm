package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U1;

import java.io.InputStream;


public class UnParsed extends BaseAttributeinfo {

    public UnParsed(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        for (int i = 0; i < attributeLength.getValue(); i++) {
            U1.read(inputStream);
        }
        return this;
    }

    @Override
    public String toString() {
        return "UnParsed attributeLength = " + attributeLength;
    }
}
