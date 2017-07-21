package com.nick.jvm.model.accessflags;

public class InnerClassFlags implements AccessFlags {
    // ACC_PUBLIC 0x0001 Դ�ļ�����public
    // ACC_PRIVATE 0x0002 Դ�ļ�����private
    // ACC_PROTECTED 0x0004 Դ�ļ�����protected
    // ACC_STATIC 0x0008 Դ�ļ�����static
    // ACC_FINAL 0x0010 Դ�ļ�����final
    // ACC_INTERFACE 0x0200 Դ�ļ�����interface
    // ACC_ABSTRACT 0x0400 Դ�ļ�����abstract
    // ACC_SYNTHETIC 0x1000 ����synthetic����Դ�ļ�����
    // ACC_ANNOTATION 0x2000 ����annotation
    // ACC_ENUM 0x4000 ����enum

    private static short ACC_PUBLIC = 0x0001;
    private static short ACC_PRIVATE = 0x0002;
    private static short ACC_PROTECTED = 0x0004;
    private static short ACC_STATIC = 0x0008;
    private static short ACC_FINAL = 0x0010;
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
        if ((flags & ACC_PRIVATE) != 0) {
            stringBuilder.append(" super ");
        }
        if ((flags & ACC_PROTECTED) != 0) {
            stringBuilder.append(" super ");
        }
        if ((flags & ACC_STATIC) != 0) {
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
