package com.nick.jvm.model.attributeinfo;

import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.cpinfo.CpInfo;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;
import java.util.Arrays;


public class BootstrapMethodsAttribute extends BaseAttributeinfo {

    public U2 numBootstrapMethods;
    public BootstrapMethod[] bootstrapMethods;

    public BootstrapMethodsAttribute(InputStream inputStream, CpInfo[] cpInfos) {
        super(inputStream, cpInfos);
    }

    @Override
    public String toString() {
        return "BootstrapMethods{" + "attributeNameIndex=" + attributeNameIndex.getValue() + " [attribute name = "
                + ((ConstantUtf8Info) (cpInfos[attributeNameIndex.getValue() - 1])).bytesValue + "]"
                + ", attributeLength=" + attributeNameIndex.getValue() + ", numBootstrapMethods=" + numBootstrapMethods
                + ", bootstrapMethod=" + Arrays.toString(bootstrapMethods) + '}';
    }

    @Override
    public BaseAttributeinfo create(InputStream inputStream) {
        numBootstrapMethods = U2.read(inputStream);
        bootstrapMethods = new BootstrapMethod[numBootstrapMethods.getValue()];

        for (int i = 0; i < bootstrapMethods.length; i++) {
            bootstrapMethods[i] = new BootstrapMethod();
            bootstrapMethods[i].bootstrapMethodRef = U2.read(inputStream);
            bootstrapMethods[i].numBootstrapArguments = U2.read(inputStream);
            bootstrapMethods[i].bootstrapArguments = new U2[bootstrapMethods[i].numBootstrapArguments.getValue()];
        }

        return this;
    }

    public static class BootstrapMethod {
        public U2 bootstrapMethodRef;
        public U2 numBootstrapArguments;
        public U2[] bootstrapArguments;

        @Override
        public String toString() {
            return "BootstrapMethod{" + "bootstrapMethodRef=" + bootstrapMethodRef + ", numBootstrapArguments="
                    + numBootstrapArguments + ", bootstrapArguments=" + bootstrapArguments + '}';
        }
    }
}
