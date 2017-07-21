package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;

import java.io.InputStream;

public class Deprecated extends BaseAttributeinfo {

    public Deprecated(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        return this;
    }

    @Override
    public String toString() {
        return "Deprecated{" + "attributeNameIndex=" + getAttributeNameIndex() + " [attribute name = "
                + ((ConstantUtf8Info) (getCpInfos()[getAttributeNameIndex().getValue() - 1])).bytesValue + "]"
                + ", attributeLength=" + getAttributeLength() + '}';
    }
}
