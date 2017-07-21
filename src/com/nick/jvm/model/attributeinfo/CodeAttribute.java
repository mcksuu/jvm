package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U1;
import com.nick.jvm.model.type.U2;
import com.nick.jvm.model.type.U4;

import java.io.InputStream;
import java.util.Arrays;


public class CodeAttribute extends BaseAttributeinfo {

    // u2 attribute_name_index;
    // u4 attribute_length;
    // u2 max_stack;
    // u2 max_locals;
    // u4 code_length;
    // u1 code[code_length];
    // u2 exception_table_length;
    // { u2 start_pc;
    // u2 end_pc;
    // u2 handler_pc;
    // u2 catch_type; } exception_table[exception_table_length];
    // u2 attributes_count;
    // attribute_info attributes[attributes_count];
    public U2 maxStack;
    public U2 maxLocals;
    public U4 codeLength;
    public U1[] code;
    public U2 exceptionTableLength;
    public ExceptionTable[] exceptionTables;
    public U2 attributesCount;
    public BaseAttributeinfo[] attributeinfos;

    public CodeAttribute(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    public static class ExceptionTable {
        public U2 startPc;
        public U2 endPc;
        public U2 handlerPc;
        public U2 catchType;
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        maxStack = U2.read(inputStream);
        maxLocals = U2.read(inputStream);
        codeLength = U4.read(inputStream);

        code = new U1[codeLength.getValue()];

        for (int i = 0; i < code.length; i++) {
            code[i] = U1.read(inputStream);
        }

        exceptionTableLength = U2.read(inputStream);
        exceptionTables = new ExceptionTable[exceptionTableLength.getValue()];

        for (int i = 0; i < exceptionTables.length; i++) {
            exceptionTables[i] = new ExceptionTable();
            exceptionTables[i].startPc = U2.read(inputStream);
            exceptionTables[i].endPc = U2.read(inputStream);
            exceptionTables[i].handlerPc = U2.read(inputStream);
            exceptionTables[i].catchType = U2.read(inputStream);
        }

        attributesCount = U2.read(inputStream);
        attributeinfos = new BaseAttributeinfo[attributesCount.getValue()];

        for (int i = 0; i < attributeinfos.length; i++) {
            U2 cout = U2.read(inputStream);
            attributeinfos[i] = newBaseAttribute(inputStream, cout, cpInfos);
            attributeinfos[i].create(inputStream);
        }

        return this;
    }

    @Override
    public String toString() {
        return "Code{" + "attributeNameIndex=" + getAttributeNameIndex() + " [attribute name = "
                + ((ConstantUtf8Info) (cpInfos[getAttributeNameIndex().getValue() - 1])).bytesValue + "]"
                + ", attributeLength=" + getAttributeLength() + ", maxStack=" + maxStack + ", maxLocals=" + maxLocals
                + ", codeLength=" + codeLength + ", code=" + Arrays.toString(code) + ", exceptionTableLength="
                + exceptionTableLength + ", exceptionTable=" + Arrays.toString(exceptionTables) + ", attributesCount="
                + attributesCount + ", attributes=" + Arrays.toString(attributeinfos) + '}';
    }
}
