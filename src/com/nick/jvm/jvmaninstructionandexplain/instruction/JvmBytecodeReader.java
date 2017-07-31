package com.nick.jvm.jvmaninstructionandexplain.instruction;

import com.nick.jvm.model.type.U1;
import com.nick.jvm.model.type.U2;
import com.nick.jvm.model.type.U4;

/**
 * Created by KangShuai on 2017/7/19.
 */
public class JvmBytecodeReader {
    public byte[] code;
    public int pc;

    public void reset(byte[] code, int pc) {
        this.code = code;
        this.pc = pc;
    }

    public U1 readUint8() {
        U1 u1 = new U1(code[pc]);
        pc++;
        return u1;
    }

    public U1 readInt8() {
        return readUint8();
    }

    public U2 readUint16() {
        U2 u2 = new U2((short) (((code[pc]) & 0xff) << 8 | ((code[pc + 1]) & 0xff)));
        pc += 2;
        return u2;
    }

    public U2 readInt16() {
        return readUint16();
    }

    public U4 readUint32() {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value <<= 8;
            value |= code[pc + i] & 0xFF;
        }
        U4 u4 = new U4(value);
        pc += 4;
        return u4;
    }

    public U4 readInt32() {
        return readUint32();
    }

    public void skipPadding() {
        if (pc % 4 != 0) {
            readInt8();
        }
    }
}
