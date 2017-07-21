package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class ConstantValueAttribute extends BaseAttributeinfo {
    // u2 attribute_name_index;
    // u4 attribute_length;
    // u2 constantvalue_index;
    public U2 constantvalueIndex;

    public ConstantValueAttribute(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        constantvalueIndex = U2.read(inputStream);
        return this;
    }

    @Override
    public String toString() {
        return "ConstantValue{" + "attributeNameIndex=" + getAttributeNameIndex() + " [attribute name = "
                + ((ConstantUtf8Info) (cpInfos[getAttributeNameIndex().getValue() - 1])).bytesValue + "]"
                + ", attributeLength=" + getAttributeLength() + ", constantValueIndex=" + constantvalueIndex + '}';
    }
}
