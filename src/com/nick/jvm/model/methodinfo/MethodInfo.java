package com.nick.jvm.model.methodinfo;

import com.nick.jvm.model.accessflags.AccessFlags;
import com.nick.jvm.model.accessflags.InnerClassFlags;
import com.nick.jvm.model.attributeinfo.BaseAttributeinfo;
import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.util.Arrays;


public class MethodInfo {

    // u2 access_flags;
    // u2 name_index;
    // u2 descriptor_index;
    // u2 attributes_count;
    // attribute_info attributes[attributes_count];
    public U2 accessFlags;
    public U2 nameIndex;
    public U2 descriptorIndex;
    public U2 attributesCount;
    public BaseAttributeinfo[] attributeinfos;
    public CpInfo[] cpinfos;

    public MethodInfo(CpInfo[] cpinfos) {
        this.cpinfos = cpinfos;
    }

    public CpInfo[] getCpinfos() {
        return cpinfos;
    }

    @Override
    public String toString() {
        return "MethodInfo{" + "accessFlags=" + accessFlags + ": "
                + AccessFlags.getFormattedAccessFlags(new InnerClassFlags(), accessFlags.getValue()) + ", nameIndex="
                + nameIndex + " [name = " + ((ConstantUtf8Info) (getCpinfos()[nameIndex.getValue() - 1])).bytesValue
                + "]" + ", descriptorIndex=" + descriptorIndex + " [descriptor = "
                + ((ConstantUtf8Info) (getCpinfos()[descriptorIndex.getValue() - 1])).bytesValue + "]"
                + ", attributesCount=" + attributesCount + ", attributes=" + Arrays.toString(attributeinfos) + '}';
    }
}
