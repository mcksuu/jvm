package com.nick.jvm.entry;

/**
 * Created by KangShuai on 2017/7/14.
 */
public class CompositeEntry extends BaseEntry {
    public CompositeEntry(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] readClass() {
        String[] singleClassPath = classPath.split(";");
        for (String s : singleClassPath) {
            Entry.newEntry(s).readClass();
        }
        return new byte[0];
    }

}
