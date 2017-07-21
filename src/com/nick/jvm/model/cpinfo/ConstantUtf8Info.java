package com.nick.jvm.model.cpinfo;

import com.nick.jvm.model.type.U2;

import java.io.IOException;
import java.io.InputStream;


public class ConstantUtf8Info extends CpInfo {

    private short length;// UF-8������ַ���ռ�õ��ֽ���
    public String bytesValue;// utf-8ֵ
    private byte[] bytes; // ����Ϊlength��UTF-8������ַ���

    public ConstantUtf8Info() {
        this.tag = CONSTANT_UTF8_INFO;
    }

    @Override
    public void read(InputStream inputStream) {
        U2 u2 = U2.read(inputStream);
        length = u2.getValue();
        bytes = new byte[length];

        try {
            inputStream.read(bytes);
            bytesValue = new String(bytes, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertMUTF8(byte[] bytes) {
        byte[] originalBytes = bytes;
        int nullCount = 0;
        for (int i = 0; i < originalBytes.length; i++) {
            if (originalBytes[i] == 0) {
                nullCount++;
            }
        }
        byte[] convertedBytes = new byte[originalBytes.length + nullCount];
        for (int i = 0, j = 0; i < originalBytes.length; i++, j++) {
            convertedBytes[j] = originalBytes[i];
            if (originalBytes[i] == 0) {
                convertedBytes[j] = (byte) 0xC0;
                ++j;
                convertedBytes[j] = (byte) 0x80;
            }
        }
    }

    @Override
    public String toString() {
        return "ConstantUtf8Info{" + "bytesValue='" + bytesValue + '\'' + '}';
    }
}
