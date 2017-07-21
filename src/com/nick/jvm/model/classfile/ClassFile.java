package com.nick.jvm.model.classfile;


import com.nick.jvm.model.attributeinfo.BaseAttributeinfo;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.field.FieldInfo;
import com.nick.jvm.model.methodinfo.MethodInfo;
import com.nick.jvm.model.type.U2;
import com.nick.jvm.model.type.U4;

public class ClassFile {
    public U4 magic; // magic
    public U2 minorVersion; // minor_version
    public U2 majorVersion; // major_version
    public U2 constantPoolCount; // constant_pool_count
    public CpInfo[] cpInfo; // cp_info
    public U2 accessFlags; // access_flags
    public U2 thisClass;// this_class
    public U2 superClass;// super_class
    public U2 interfacesCount;// interfaces_count
    public U2[] interfaces;// interfaces
    public U2 fieldsCount;// fields_count
    public FieldInfo[] fieldInfo;
    public U2 methodsCount;// methods_count
    public MethodInfo[] methodInfos;
    public U2 attributesCount;// attributes_count;
    public BaseAttributeinfo[] attributes; // attributes [attributes_count];
}
