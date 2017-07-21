package com.nick.jvm.model.type;

import java.io.IOException;
import java.io.InputStream;

public class U2 extends BaseicType<Short> {

    public U2(short value) {
        this.value = value;
    }

    public static U2 read(InputStream inputStream) {
        byte[] bytes = new byte[2];
        try {
            inputStream.read(bytes);
            short value = (short) (((bytes[0]) & 0xff) << 8 | ((bytes[1]) & 0xff));
            return new U2(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
