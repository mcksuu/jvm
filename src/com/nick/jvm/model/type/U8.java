package com.nick.jvm.model.type;

import java.io.IOException;
import java.io.InputStream;

public class U8 extends BaseicType<Long> {
    public long value;

    public U8(long value) {
        this.value = value;
    }

    public static U8 read(InputStream inputStream) {
        byte[] bytes = new byte[8];
        try {
            inputStream.read(bytes);
            long value = 0;
            for (int i = 0; i < 8; i++) {
                value <<= 8;
                value |= bytes[i] & 0xFF;
            }

            return new U8(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
