package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class LocalVariableTableAttribute extends BaseAttributeinfo {

    // u2 attribute_name_index;
    // u4 attribute_length;
    // u2 local_variable_table_length;
    // { u2 start_pc;
    // u2 length;
    // u2 name_index;
    // u2 descriptor_index;
    // u2 index;
    // }local_variable_table[local_variable_table_length];}

    public U2 localVariableTableLength;
    public LocalVariableTable[] localVariableTables;

    public static class LocalVariableTable {
        public U2 startPc;
        public U2 length;
        public U2 nameIndex;
        public U2 descriptorIndex;
        public U2 index;

        @Override
        public String toString() {
            return "LocalVariableInfo{" + "startPc=" + startPc + ", length=" + length + ", nameIndex=" + nameIndex
                    + ", descriptorIndex=" + descriptorIndex + ", index=" + index + '}';
        }
    }

    public LocalVariableTableAttribute(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        localVariableTableLength = U2.read(inputStream);
        localVariableTables = new LocalVariableTable[localVariableTableLength.getValue()];
        for (int i = 0; i < localVariableTables.length; i++) {
            localVariableTables[i] = new LocalVariableTable();
            localVariableTables[i].startPc = U2.read(inputStream);
            localVariableTables[i].length = U2.read(inputStream);
            localVariableTables[i].nameIndex = U2.read(inputStream);
            localVariableTables[i].descriptorIndex = U2.read(inputStream);
            localVariableTables[i].index = U2.read(inputStream);
        }
        return this;
    }

    @Override
    public String toString() {
        return "LocalVariableTable{" + "attributeNameIndex=" + getAttributeNameIndex() + " [attribute name = "
                + ((ConstantUtf8Info) (getCpInfos()[getAttributeNameIndex().getValue() - 1])).bytesValue + "]"
                + ", attributeLength=" + getAttributeLength() + ", localVariableTableLength=" + localVariableTableLength
                + '}';
    }
}
