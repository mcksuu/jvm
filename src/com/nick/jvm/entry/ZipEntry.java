package com.nick.jvm.entry;

import java.io.*;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by KangShuai on 2017/7/14.
 */
public class ZipEntry extends BaseEntry {
    public ZipEntry(String classPath) {
        super(classPath);
    }

    @Override
    public byte[] readClass() {
        InputStream inputStream = null;
        ZipInputStream zipInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            ZipFile zipFile = new ZipFile(classPath);
            inputStream = new BufferedInputStream(new FileInputStream(classPath));
            zipInputStream = new ZipInputStream(inputStream);
            java.util.zip.ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (!zipEntry.isDirectory()) {
                    System.out.println("fileName = " + zipEntry.getName() + " fileSize = " + zipEntry.getSize() + " bytes");
                    inputStreamReader = new InputStreamReader(zipFile.getInputStream(zipEntry));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(zipEntry)));
                    String string;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((string = bufferedReader.readLine()) != null) {
                        stringBuilder.append(string);
                    }
                    String string1 = stringBuilder.toString();
                    char[] chars = string1.toCharArray();
                    for (char aChar : chars) {
                        System.out.print((byte) aChar + " ");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new byte[0];
    }
}
