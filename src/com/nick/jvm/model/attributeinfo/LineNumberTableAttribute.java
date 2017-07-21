package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;
import java.util.Arrays;


public class LineNumberTableAttribute extends BaseAttributeinfo {
    // u2 line_number_table_length;
    // { u2 start_pc;
    // u2 line_number; }
    // line_number_table[line_number_table_length];
    public U2 lineNumberTableLength;
    public LineNumberTable[] lineNumberTables;

    public LineNumberTableAttribute(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        lineNumberTableLength = U2.read(inputStream);
        lineNumberTables = new LineNumberTable[lineNumberTableLength.getValue()];

        for (int i = 0; i < lineNumberTables.length; i++) {
            lineNumberTables[i] = new LineNumberTable();
            lineNumberTables[i].startPc = U2.read(inputStream);
            lineNumberTables[i].lineNumber = U2.read(inputStream);
        }

        return this;
    }

    @Override
    public String toString() {
        return "LineNumberTable{" + "attributeNameIndex=" + getAttributeNameIndex() + " [attribute name = "
                + ((ConstantUtf8Info) (getCpInfos()[getAttributeNameIndex().getValue() - 1])).bytesValue + "]"
                + ", attributeLength=" + getAttributeLength() + ", lineNumberTableLength=" + lineNumberTableLength
                + ", lineNumberTable=" + Arrays.toString(lineNumberTables) + '}';
    }

    public static class LineNumberTable {
        U2 startPc;
        U2 lineNumber;

        @Override
        public String toString() {
            return "LineNumberInfo{" + "startPc=" + startPc + ", lineNumber=" + lineNumber + '}';
        }
    }
}
