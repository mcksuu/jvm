package com.nick.jvm.model.accessflags;

public interface AccessFlags {


    public abstract String getFormatFlags(short flags);

    public static String getFormattedAccessFlags(AccessFlags accessFlags, short accessFlagsIndex) {
        return accessFlags.getFormatFlags(accessFlagsIndex);
    }
}
