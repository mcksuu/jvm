package com.nick.jvm.model.field;

import com.nick.jvm.model.accessflags.AccessFlags;
import com.nick.jvm.model.attributeinfo.BaseAttributeinfo;
import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.util.Arrays;


public class FieldInfo implements AccessFlags {
    // u2 access_flags;
    // u2 name_index;
    // u2 descriptor_index;
    // u2 attributes_count;
    // attribute_info attributes[attributes_count];
    // ACC_PUBLIC 0x0001 public����ʾ�ֶο��Դ��κΰ����ʡ�
    // ACC_PRIVATE 0x0002 private����ʾ�ֶν��ܸ���������á�
    // ACC_PROTECTED 0x0004 protected����ʾ�ֶο��Ա�������á�
    // ACC_STATIC 0x0008 static����ʾ��̬�ֶΡ�
    // ACC_FINAL 0x0010 final����ʾ�ֶζ����ֵ�޷��޸ģ�JLS ��17.5����
    // ACC_VOLATILE 0x0040 volatile����ʾ�ֶ����ױ�ġ�
    // ACC_TRANSIENT 0x0080 transient����ʾ�ֶβ��ᱻ���л���
    // ACC_SYNTHETIC 0x1000 ��ʾ�ֶ��ɱ������Զ�������
    // ACC_ENUM 0x4000 enum����ʾ�ֶ�Ϊö�����͡�
    private short ACC_PUBLIC = 0x0001;
    private short ACC_PRIVATE = 0x0002;
    private short ACC_PROTECTED = 0x0004;
    private short ACC_STATIC = 0x0008;
    private short ACC_FINAL = 0x0010;
    private short ACC_VOLATILE = 0x0040;
    private short ACC_TRANSIENT = 0x0080;
    private short ACC_SYNTHETIC = 0x1000;
    private short ACC_ENUM = 0x4000;

    public U2 accessFlags;
    public U2 nameIndex;
    public U2 descriptorIndex;
    public U2 attributesCount;
    public BaseAttributeinfo[] attributes;
    private CpInfo[] cpinfos;

    public FieldInfo(CpInfo[] cpinfos) {
        this.cpinfos = cpinfos;
    }

    @Override
    public String getFormatFlags(short flags) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((flags & ACC_PUBLIC) != 0) {
            stringBuilder.append(" public ");
        }
        if ((flags & ACC_PRIVATE) != 0) {
            stringBuilder.append(" private ");
        }
        if ((flags & ACC_PROTECTED) != 0) {
            stringBuilder.append(" protected ");
        }
        if ((flags & ACC_STATIC) != 0) {
            stringBuilder.append(" static ");
        }
        if ((flags & ACC_FINAL) != 0) {
            stringBuilder.append(" interface ");
        }
        if ((flags & ACC_VOLATILE) != 0) {
            stringBuilder.append(" final ");
        }
        if ((flags & ACC_TRANSIENT) != 0) {
            stringBuilder.append(" transient ");
        }
        if ((flags & ACC_SYNTHETIC) != 0) {
            stringBuilder.append(" synthetic ");
        }
        if ((flags & ACC_ENUM) != 0) {
            stringBuilder.append(" enum ");
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "FieldInfo{" + "accessFlags=" + accessFlags + ": "
                + AccessFlags.getFormattedAccessFlags(this, accessFlags.getValue()) + ", nameIndex=" + nameIndex
                + " [name = " + ((ConstantUtf8Info) (getCpinfos()[nameIndex.getValue() - 1])).bytesValue + "]"
                + ", descriptorIndex=" + descriptorIndex + " [descriptor = "
                + ((ConstantUtf8Info) (getCpinfos()[descriptorIndex.getValue() - 1])).bytesValue + "]"
                + ", attributesCount=" + attributesCount + ", attributes=" + Arrays.toString(attributes) + '}';
    }

    public CpInfo[] getCpinfos() {
        return cpinfos;
    }

    public void setCpinfos(CpInfo[] cpinfos) {
        this.cpinfos = cpinfos;
    }
}
