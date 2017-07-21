package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;
import java.util.Arrays;


public class Exceptions extends BaseAttributeinfo {

    // u2 attribute_name_index;
    // u4 attribute_length;
    // u2 number_of_exceptions;
    // u2 exception_index_table[number_of_exceptions];
    public U2 numberOfExceptions;
    public U2[] exceptionIndexTable;

    public Exceptions(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        numberOfExceptions = U2.read(inputStream);
        exceptionIndexTable = new U2[numberOfExceptions.getValue()];

        for (int i = 0; i < exceptionIndexTable.length; i++) {
            exceptionIndexTable[i] = U2.read(inputStream);

        }
        return this;
    }

    @Override
    public String toString() {
        return "Exceptions{" + "attributeNameIndex=" + getAttributeNameIndex() + " [attribute name = "
                + ((ConstantUtf8Info) (getCpInfos()[getAttributeNameIndex().getValue() - 1])).bytesValue + "]"
                + ", attributeLength=" + getAttributeLength() + ", numberOfExceptions=" + numberOfExceptions
                + ", exceptionIndexTable=" + Arrays.toString(exceptionIndexTable) + '}';
    }
}
