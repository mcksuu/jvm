package com.nick.jvm.model.accessflags;

public class ClassAccessFlags implements AccessFlags {
    // ����� ֵ ����
    // ACC_PUBLIC 0x0001 ���Ա�����������ʡ�
    // ACC_FINAL 0x0010 �����������ࡣ
    // ACC_SUPER 0x0020 ���õ�invokespecialָ��ʱ����Ҫ���⴦��۵ĸ��෽����
    // ACC_INTERFACE 0x0200 ��ʶ������ǽӿڶ������ࡣ
    // ACC_ABSTRACT 0x0400 ���ܱ�ʵ������
    // ACC_SYNTHETIC 0x1000 ��ʶ����JavaԴ�����ɵĴ��롣
    // ACC_ANNOTATION 0x2000 ��ʶע������
    // ACC_ENUM 0x4000 ��ʶö������
    private static short ACC_PUBLIC = 0x0001;
    private static short ACC_FINAL = 0x0010;
    private static short ACC_SUPER = 0x0020;
    private static short ACC_INTERFACE = 0x0200;
    private static short ACC_ABSTRACT = 0x0400;
    private static short ACC_SYNTHETIC = 0x1000;
    private static short ACC_ANNOTATION = 0x2000;
    private static short ACC_ENUM = 0x4000;

    @Override
    public String getFormatFlags(short flags) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((flags & ACC_PUBLIC) != 0) {
            stringBuilder.append(" public ");
        }
        if ((flags & ACC_FINAL) != 0) {
            stringBuilder.append(" final ");
        }
        if ((flags & ACC_SUPER) != 0) {
            stringBuilder.append(" super ");
        }
        if ((flags & ACC_INTERFACE) != 0) {
            stringBuilder.append(" interface ");
        }
        if ((flags & ACC_ABSTRACT) != 0) {
            stringBuilder.append(" abstract ");
        }
        if ((flags & ACC_SYNTHETIC) != 0) {
            stringBuilder.append(" synthetic ");
        }
        if ((flags & ACC_ANNOTATION) != 0) {
            stringBuilder.append(" annotation ");
        }
        if ((flags & ACC_ENUM) != 0) {
            stringBuilder.append(" enum ");
        }

        return stringBuilder.toString();
    }

}
