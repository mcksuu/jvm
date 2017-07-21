package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U1;

import java.io.InputStream;


public class SourceDebugExtension extends BaseAttributeinfo {
    public U1[] debugExtension;

    public SourceDebugExtension(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        debugExtension = new U1[attributeLength.getValue()];

        for (int i = 0; i < debugExtension.length; i++) {
            debugExtension[i] = U1.read(inputStream);
        }

        return this;
    }

}
