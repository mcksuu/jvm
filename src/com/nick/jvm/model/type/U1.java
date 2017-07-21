package com.nick.jvm.model.type;

import java.io.IOException;
import java.io.InputStream;

public class U1 extends BaseicType<Byte> implements IBasicType<Byte> {

    public U1(byte value) {
        this.value = value;
    }

    public static U1 read(InputStream inputStream) {
        byte[] bytes = new byte[1];
        try {
            inputStream.read(bytes);
            return new U1(bytes[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Byte getValue() {
        return value;
    }

    @Override
    public String getHexValue() {
        String hexString = Integer.toHexString(value & 0xff);
        return hexString;
    }

    @Override
    public String toString() {
        return getHexValue();
    }
}
