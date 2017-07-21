package com.nick.jvm.entry;

import java.io.File;

/**
 * 带*的路径
 * Created by KangShuai on 2017/7/14.
 */
public class WildcardEntry extends BaseEntry {
    public WildcardEntry(String path) {
        super(path);
    }

    @Override
    public byte[] readClass() {
        String realPath = classPath.replace("*", "");

        File file = new File(realPath);
        if (file.exists()) {
            readClass(file);
        }

        return new byte[0];
    }

    private void readClass(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File listFile : listFiles) {
                readClass(listFile);
            }
        } else {
            Entry.newEntry(file.getPath()).readClass();
        }
    }
}
