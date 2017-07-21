package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class EnclosingMethod extends BaseAttributeinfo {
    // u2 attribute_name_index;
    // u4 attribute_length;
    // u2 class_index ;
    // u2 method_index;
    public U2 classIndex;
    public U2 methodIndex;

    public EnclosingMethod(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        classIndex = U2.read(inputStream);
        methodIndex = U2.read(inputStream);
        return this;
    }
    
    @Override
    public String toString() {
        
        
        
        return super.toString();
    }
}
