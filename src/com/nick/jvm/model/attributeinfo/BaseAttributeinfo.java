package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;
import com.nick.jvm.model.type.U4;

import java.io.InputStream;
import java.lang.*;
import java.lang.reflect.Field;


public abstract class BaseAttributeinfo {
    // ConstantValue����4.7.2�� 1.0.2 45.3
    // Code����4.7.3�� 1.0.2 45.3
    // StackMapTable����4.7.4�� 6 50.0
    // Exceptions����4.7.5�� 1.0.2 45.3
    // InnerClasses����4.7.6�� 1.1 45.3 EnclosingMethod����4.7.7�� 5.0 49.0
    // Synthetic����4.7.8�� 1.1 45.3
    // Signature����4.7.9�� 5.0 49.0
    // SourceFile����4.7.10�� 1.0.2 45.3
    // SourceDebugExtension����4.7.11�� 5.0 49.0
    // LineNumberTable����4.7.12�� 1.0.2 45.3
    // LocalVariableTable����4.7.13�� 1.0.2 45.3
    // LocalVariableTypeTable����4.7.14�� 5.0 49.0
    // Deprecated����4.7.15�� 1.1 45.3
    // RuntimeVisibleAnnotations����4.7.16�� 5.0 49.0
    // RuntimeInvisibleAnnotations����4.7.17�� 5.0 49.0
    // RuntimeVisibleParameterAnnotations����4.7.18�� 5.0 49.0
    // RuntimeInvisibleParameterAnnotations����4.7.19�� 5.0 49.0
    // AnnotationDefault����4.7.20�� 5.0 49.0
    // BootstrapMethods����4.7.21�� 7 51.0

    // u2 attribute_name_index;
    // u4 attribute_length;
    // u1 info[attribute_length];
    public U2 attributeNameIndex;
    public U4 attributeLength;
    public CpInfo[] cpInfos;

    public BaseAttributeinfo(InputStream inputStream, CpInfo[] cpInfos) {
        attributeLength = U4.read(inputStream);
        this.cpInfos = cpInfos;
    }

    public abstract BaseAttributeinfo create(InputStream inputStream);

    public static BaseAttributeinfo newBaseAttribute(InputStream inputStream, U2 attributeNameIndex, CpInfo[] cpInfos) {
        String cString = ((ConstantUtf8Info) cpInfos[attributeNameIndex.getValue() - 1]).bytesValue;
        BaseAttributeinfo baseAttributeinfo = null;
        switch (cString) {
        case "ConstantValue":
            baseAttributeinfo = new ConstantValueAttribute(inputStream, cpInfos);
            break;
        case "Code":
            baseAttributeinfo = new CodeAttribute(inputStream, cpInfos);
            break;
        case "StackMapTable":
            baseAttributeinfo = new UnParsed(inputStream, cpInfos);
            break;
        case "Exceptions":
            baseAttributeinfo = new Exceptions(inputStream, cpInfos);
            break;
        case "InnerClasses":
            baseAttributeinfo = new InnerClassesAttribute(inputStream, cpInfos);
            break;
        case "EnclosingMethod":
            baseAttributeinfo = new EnclosingMethod(inputStream, cpInfos);
            break;
        case "Synthetic":
            baseAttributeinfo = new Synthetic(inputStream, cpInfos);
            break;
        case "SourceFile":
            baseAttributeinfo = new SourceFile(inputStream, cpInfos);
            break;
        case "SourceDebugExtension":
            baseAttributeinfo = new SourceDebugExtension(inputStream, cpInfos);
            break;
        case "LineNumberTable":
            baseAttributeinfo = new LineNumberTableAttribute(inputStream, cpInfos);
            break;
        case "LocalVariableTable":
            baseAttributeinfo = new LocalVariableTableAttribute(inputStream, cpInfos);
            break;
        case "LocalVariableTypeTable":
            baseAttributeinfo = new LocalVariableTypeTableAttribute(inputStream, cpInfos);
            break;
        case "Deprecated":
            baseAttributeinfo = new Deprecated(inputStream, cpInfos);
            break;
        case "RuntimeVisibleAnnotations":
            baseAttributeinfo = new UnParsed(inputStream, cpInfos);
            break;
        case "RuntimeInvisibleAnnotations":
            baseAttributeinfo = new UnParsed(inputStream, cpInfos);
            break;
        case "RuntimeVisibleParameterAnnotations":
            baseAttributeinfo = new UnParsed(inputStream, cpInfos);
            break;
        case "RuntimeInvisibleParameterAnnotations":
            baseAttributeinfo = new UnParsed(inputStream, cpInfos);
            break;
        case "AnnotationDefault":
            baseAttributeinfo = new UnParsed(inputStream, cpInfos);
            break;
        case "BootstrapMethods":
            baseAttributeinfo = new BootstrapMethodsAttribute(inputStream, cpInfos);
            break;
        }
        if (baseAttributeinfo != null) {
            baseAttributeinfo.attributeNameIndex = attributeNameIndex;
        }

        return baseAttributeinfo;
    }

    public void setAttributeNameIndex(U2 attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public U2 getAttributeNameIndex() {
        return attributeNameIndex;
    }
    
    public U4 getAttributeLength() {
        return attributeLength;
    }

    public CpInfo[] getCpInfos() {
        return cpInfos;
    }
    
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        Field[] declaredFields = getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            stringBuilder.append(field.getName() + " = ");
            try {
                Object object = field.get(this);
                if (object != null) {
                    stringBuilder.append(object.toString() + " ");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return stringBuilder.toString();
    }
}
