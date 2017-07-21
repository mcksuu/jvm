package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class StackMapTable extends BaseAttributeinfo {
    // u2 number_of_entries;
    // stack_map_frame entries[number_of_entries];
    public U2 numberOfEntries;

    public StackMapTable(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    public static class StackMapFrame {

    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        // numberOfEntries = U2.read(inputStream);
        return this;
    }
}
