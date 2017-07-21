package com.nick.jvm.entry;

/**
 * Created by KangShuai on 2017/7/14.
 */
public interface Entry {
    String PATH_LIST_SEPARATOR = ";";


    byte[] readClass();

    static Entry newEntry(String path) {
        if (path.contains(PATH_LIST_SEPARATOR)) {
            return new CompositeEntry(path);
        } else if (path.endsWith("zip") || path.endsWith("ZIP") || path.endsWith("jar") || path.endsWith("JAR")) {
            return new ZipEntry(path);
        } else if (path.contains("*")) {
            return new WildcardEntry(path);
        }

        return new DirEntry(path);
    }
}
