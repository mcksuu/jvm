package com.nick.jvm.entry;

/**
 * Created by KangShuai on 2017/7/14.
 */
public abstract class BaseEntry implements Entry {
    protected String classPath;

    public BaseEntry(String classPath) {
        this.classPath = classPath;
    }
}
