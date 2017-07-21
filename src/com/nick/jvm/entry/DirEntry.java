package com.nick.jvm.entry;

import java.io.*;

/**
 * Created by KangShuai on 2017/7/14.
 */
public class DirEntry extends BaseEntry {
    public DirEntry(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] readClass() {
        try {
            byte[] bytes = new byte[1024];
            FileInputStream fileReader = new FileInputStream(classPath);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            int n;
            try {
                while ((n = fileReader.read(bytes)) != -1) {
                    byteArrayOutputStream.write(bytes, 0, n);
                }

                byte[] byteArray = byteArrayOutputStream.toByteArray();
                for (byte b : byteArray) {
                    System.out.print(b + " ");
                }
                return byteArray;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
