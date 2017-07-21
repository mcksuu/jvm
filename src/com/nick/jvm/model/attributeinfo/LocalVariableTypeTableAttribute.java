package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;
import java.util.Arrays;


public class LocalVariableTypeTableAttribute extends BaseAttributeinfo {

    // u2 local_variable_type_table_length;
    // { u2 start_pc; u2 length;
    // u2 name_index;
    // u2 signature_index;
    // u2 index; }
    // local_variable_type_table[local_variable_type_table_length];

    public U2 localVariableTypeTableLength;
    public LocalVariableTypeTable[] localVariableTypeTables;

    public LocalVariableTypeTableAttribute(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        localVariableTypeTableLength = U2.read(inputStream);
        localVariableTypeTables = new LocalVariableTypeTable[localVariableTypeTableLength.getValue()];

        for (int i = 0; i < localVariableTypeTables.length; i++) {
            localVariableTypeTables[i] = new LocalVariableTypeTable();
            localVariableTypeTables[i].startPc = U2.read(inputStream);
            localVariableTypeTables[i].length = U2.read(inputStream);
            localVariableTypeTables[i].nameIndex = U2.read(inputStream);
            localVariableTypeTables[i].signatureIndex = U2.read(inputStream);
            localVariableTypeTables[i].index = U2.read(inputStream);
        }

        return this;
    }

    public static class LocalVariableTypeTable {
        public U2 startPc;
        public U2 length;
        public U2 nameIndex;
        public U2 signatureIndex;
        public U2 index;

        @Override
        public String toString() {
            return "LocalVariableTypeTableInfo{" + "startPc=" + startPc + ", length=" + length + ", nameIndex="
                    + nameIndex + ", signatureIndex=" + signatureIndex + ", index=" + index + '}';
        }
    }

    @Override
    public String toString() {
        return "LocalVariableTypeTable{" + "localVariableTypeTableLength=" + localVariableTypeTableLength
                + ", localVariableTypeTable=" + Arrays.toString(localVariableTypeTables) + '}';
    }
}
