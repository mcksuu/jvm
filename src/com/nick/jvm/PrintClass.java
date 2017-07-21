package com.nick.jvm;

import com.nick.jvm.cmd.Cmd;
import com.nick.jvm.model.accessflags.AccessFlags;
import com.nick.jvm.model.accessflags.ClassAccessFlags;
import com.nick.jvm.model.attributeinfo.BaseAttributeinfo;
import com.nick.jvm.model.classfile.ClassFile;
import com.nick.jvm.model.cpinfo.ConstantPool;
import com.nick.jvm.model.field.FieldInfo;
import com.nick.jvm.model.methodinfo.MethodInfo;
import com.nick.jvm.model.type.U2;
import com.nick.jvm.model.type.U4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class PrintClass {

    public static void printClass(Cmd cmd) {
        try {
            InputStream inputStream = new FileInputStream(cmd.clazzPath + "\\" + cmd.clazz);
            createClassFile(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createClassFile(InputStream inputStream) {
        ClassFile classFile = new ClassFile();
        classFile.magic = U4.read(inputStream);
        System.out.println("magic:" + classFile.magic.getHexValue());
        classFile.minorVersion = U2.read(inputStream);
        System.out.println("minorVersion:" + classFile.minorVersion.getValue());
        classFile.majorVersion = U2.read(inputStream);
        System.out.println("majorVersion:" + classFile.majorVersion.getValue());
        classFile.constantPoolCount = U2.read(inputStream);
        System.out.println("constantPoolCount:" + classFile.constantPoolCount.getValue());
        ConstantPool constantPool = new ConstantPool((short) (classFile.constantPoolCount.getValue() - 1));
        constantPool.general(inputStream);
        classFile.cpInfo = constantPool.getCpInfo();
        for (int i = 0; i < classFile.cpInfo.length; i++) {
            if (classFile.cpInfo[i] != null) {
                System.out.println("cpInfo[" + (i + 1) + "] = " + classFile.cpInfo[i]);
            }
        }

        classFile.accessFlags = U2.read(inputStream);
        System.out.println("access_flags " + classFile.accessFlags.getHexValue()
                + AccessFlags.getFormattedAccessFlags(new ClassAccessFlags(), classFile.accessFlags.getValue()));

        classFile.thisClass = U2.read(inputStream);
        System.out.println("this_class " + classFile.thisClass.getHexValue() + " this class name = "
                + classFile.cpInfo[classFile.thisClass.getValue()]);

        classFile.superClass = U2.read(inputStream);

        if (classFile.superClass.getValue() == 0) {
            System.out.println("super_class " + classFile.superClass.getHexValue() + " super class name = null ");
        } else {
            System.out.println("super_class " + classFile.superClass.getHexValue() + " super class name = "
                    + classFile.cpInfo[classFile.superClass.getValue()]);
        }

        classFile.interfacesCount = U2.read(inputStream);
        System.out.println("interfaces_count " + classFile.interfacesCount.getValue());

        classFile.interfaces = new U2[classFile.interfacesCount.getValue()];

        for (int j = 0; j < classFile.interfaces.length; j++) {
            classFile.interfaces[j] = U2.read(inputStream);
            System.out.println("interface[" + j + "] = " + classFile.cpInfo[classFile.interfaces[j].getValue()]);
        }

        classFile.fieldsCount = U2.read(inputStream);
        System.out.println("fields_count = " + classFile.fieldsCount.getValue());

        classFile.fieldInfo = new FieldInfo[classFile.fieldsCount.getValue()];

        for (int i = 0; i < classFile.fieldInfo.length; i++) {
            classFile.fieldInfo[i] = new FieldInfo(classFile.cpInfo);
            classFile.fieldInfo[i].accessFlags = U2.read(inputStream);
            classFile.fieldInfo[i].nameIndex = U2.read(inputStream);
            classFile.fieldInfo[i].descriptorIndex = U2.read(inputStream);
            classFile.fieldInfo[i].attributesCount = U2.read(inputStream);
            classFile.fieldInfo[i].attributes = new BaseAttributeinfo[classFile.fieldInfo[i].attributesCount
                    .getValue()];
            System.out.println("FieldInfo[" + "]" + classFile.fieldInfo[i]);

            for (int j = 0; j < classFile.fieldInfo[i].attributes.length; j++) {
                classFile.fieldInfo[i].attributes[j] = BaseAttributeinfo.newBaseAttribute(inputStream,
                        U2.read(inputStream), classFile.cpInfo);
                classFile.fieldInfo[i].attributes[j].create(inputStream);
                System.out.println("Attributeinfo[" + j + "]" + classFile.fieldInfo[i].attributes[j]);
            }
        }

        classFile.methodsCount = U2.read(inputStream);
        classFile.methodInfos = new MethodInfo[classFile.methodsCount.getValue()];

        System.out.println("methodCount = " + classFile.methodsCount);
        for (int j = 0; j < classFile.methodInfos.length; j++) {
            classFile.methodInfos[j] = new MethodInfo(classFile.cpInfo);
            classFile.methodInfos[j].accessFlags = U2.read(inputStream);
            classFile.methodInfos[j].nameIndex = U2.read(inputStream);
            classFile.methodInfos[j].descriptorIndex = U2.read(inputStream);
            classFile.methodInfos[j].attributesCount = U2.read(inputStream);
            classFile.methodInfos[j].attributeinfos = new BaseAttributeinfo[classFile.methodInfos[j].attributesCount
                    .getValue()];

            for (int k = 0; k < classFile.methodInfos[j].attributeinfos.length; k++) {
                classFile.methodInfos[j].attributeinfos[k] = BaseAttributeinfo.newBaseAttribute(inputStream,
                        U2.read(inputStream), classFile.cpInfo);
                classFile.methodInfos[j].attributeinfos[k].create(inputStream);
            }

            System.out.println("methodInfo[" + j + "] = " + classFile.methodInfos[j]);
        }

        classFile.attributesCount = U2.read(inputStream);
        System.out.println("attributesCount = " + classFile.attributesCount);
        classFile.attributes = new BaseAttributeinfo[classFile.attributesCount.getValue()];

        for (int j = 0; j < classFile.attributes.length; j++) {
            classFile.attributes[j] = BaseAttributeinfo.newBaseAttribute(inputStream, U2.read(inputStream),
                    classFile.cpInfo);
            classFile.attributes[j].create(inputStream);
            System.out.println(classFile.attributes[j]);

        }
    }

}
