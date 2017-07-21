package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class SourceFile extends BaseAttributeinfo {

    public U2 sourceFileIndex;

    public SourceFile(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        sourceFileIndex = U2.read(inputStream);
        return this;
    }

    @Override
    public String toString() {
        return "SourceFile { attributeNameIndex = " + attributeNameIndex + ",attributeLength = " + attributeLength
                + ", sourceFileIndex = " + sourceFileIndex;
    }
}
