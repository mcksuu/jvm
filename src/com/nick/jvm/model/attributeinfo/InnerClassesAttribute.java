package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;
import java.util.Arrays;


public class InnerClassesAttribute extends BaseAttributeinfo {

    // u2 attribute_name_index;
    // u4 attribute_length;
    // u2 number_of_classes;
    // { u2 inner_class_info_index;
    // u2 outer_class_info_index;
    // u2 inner_name_index;
    // u2 inner_class_access_flags; }
    // classes[number_of_classes];

    

    public U2 numberOfClasses;
    public Classes[] classes;

    public InnerClassesAttribute(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public String toString() {
        return "InnerClasses{" + "attributeNameIndex=" + getAttributeNameIndex() + " [attribute name = "
                + ((ConstantUtf8Info) (getCpInfos()[getAttributeNameIndex().getValue() - 1])).bytesValue + "]"
                + ", attributeLength=" + getAttributeLength() + ", numberOfClasses=" + numberOfClasses
                + ", innerClasses=" + Arrays.toString(classes) + '}';
    }

    public static class Classes {
        public U2 innerClassInfoIndex;
        public U2 outerClassInfoIndex;
        public U2 innerNameIndex;
        public U2 innerClassAccessFlags;

        @Override
        public String toString() {
            return "InnerClassesInfo{" + "innerClassInfoIndex=" + innerClassInfoIndex + ", outerClassInfoIndex="
                    + outerClassInfoIndex + ", innerNameIndex=" + innerNameIndex + ", innerClassAccessFlags="
                    + innerClassAccessFlags + '}';
        }
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        numberOfClasses = U2.read(inputStream);

        classes = new Classes[numberOfClasses.getValue()];

        for (int i = 0; i < classes.length; i++) {
            classes[i] = new Classes();
            classes[i].innerClassInfoIndex = U2.read(inputStream);
            classes[i].outerClassInfoIndex = U2.read(inputStream);
            classes[i].innerNameIndex = U2.read(inputStream);
            classes[i].innerClassAccessFlags = U2.read(inputStream);
        }

        return this;
    }

    
}
