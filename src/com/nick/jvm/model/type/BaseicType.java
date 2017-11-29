package com.nick.jvm.model.type;

public class BaseicType<T> implements IBasicType<T> {
    public T value;

    @Override
    public String getHexValue() {
        String hexString = "";

        if (value instanceof Long) {
            hexString = Long.toHexString((Long) value);
        } else if (value instanceof Short) {
            hexString = Integer.toHexString((Short) value & 0xffff);
        } else if (value instanceof Byte) {
            hexString = Integer.toHexString((Byte) value & 0xffff);
        } else {
            hexString = Integer.toHexString((Integer) value);
        }

        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }

        return hexString;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
