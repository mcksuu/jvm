package com.nick.jvm.model.type;

import java.io.IOException;
import java.io.InputStream;

public class U4 extends BaseicType<Integer> {
    public U4(int value) {
        this.value = value;
    }

    public static U4 read(InputStream inputStream) {
        byte[] bytes = new byte[4];
        try {
            inputStream.read(bytes);
            int value = 0;
            for (int i = 0; i < 4; i++) {
                value <<= 8;
                value |= bytes[i] & 0xFF;
            }

            return new U4(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
