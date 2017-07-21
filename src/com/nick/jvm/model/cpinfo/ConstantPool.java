package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U1;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;


public class ConstantPool {

    private U2 constantPoolCount; // constant_pool_count
    private CpInfo[] cpInfo; // cp_info

    public ConstantPool(short constantPoolCount) {
        U2 u2 = new U2(constantPoolCount);
        this.constantPoolCount = u2;
        cpInfo = new CpInfo[this.constantPoolCount.getValue()];
    }

    public CpInfo[] getCpInfo() {
        return cpInfo;
    }

    public void setCpInfo(CpInfo[] cpInfo) {
        this.cpInfo = cpInfo;
    }

    public U2 getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(U2 constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public static CpInfo newConstantPoolInfo(Byte tagValue, InputStream inputStream) {
        CpInfo cpInfoInfo = null;
        switch (tagValue) {
        case CpInfo.CONSTANT_UTF8_INFO:
            cpInfoInfo = new ConstantUtf8Info();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_INTEGER_INFO:
            cpInfoInfo = new ConstantIntegerInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_FLOAT_INFO:
            cpInfoInfo = new ConstantFloatInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_LONG_INFO:
            cpInfoInfo = new ConstantLongInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_DOUBLE_INFO:
            cpInfoInfo = new ConstantDoubleInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_CLASS_INFO:
            cpInfoInfo = new ConstantClassInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_STRING_INFO:
            cpInfoInfo = new ConstantClassInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_FIELDREF_INFO:
            cpInfoInfo = new ConstantFieldrefInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_METHODREF_INFO:
            cpInfoInfo = new ConstantMethodrefInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_INTERFACEMETHODREF_INFO:
            cpInfoInfo = new ConstantInterfaceMethodrefInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_NAMEANDTYPE_INFO:
            cpInfoInfo = new ConstantNameAndTypeInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_METHODHANDLE_INFO:
            cpInfoInfo = new ConstantMethodHandleInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_METHODTYPE_INFO:
            cpInfoInfo = new ConstantMethodTypeInfo();
            cpInfoInfo.read(inputStream);
            break;
        case CpInfo.CONSTANT_INVOKEDYNAMIC_INFO:
            cpInfoInfo = new ConstantInvokeDynamicInfo();
            cpInfoInfo.read(inputStream);
            break;
        }
        return cpInfoInfo;
    }

    public void general(InputStream inputStream) {
        for (int i = 0; i < cpInfo.length; i++) {
            Byte value = U1.read(inputStream).getValue();
            cpInfo[i] = newConstantPoolInfo(value, inputStream);
            if (value == CpInfo.CONSTANT_LONG_INFO || value == CpInfo.CONSTANT_DOUBLE_INFO) {
                i++;
                cpInfo[i] = null;
            }
        }
    }
}
