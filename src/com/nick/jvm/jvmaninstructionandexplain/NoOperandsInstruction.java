package com.nick.jvm.jvmaninstructionandexplain;

import com.nick.jvm.jvmruntimedata.JvmFrame;

import java.io.InputStream;

/**
 * NoOperandsInstruction表示没有操作数的指令，所以没有定义
 * 任何字段
 * Created by KangShuai on 2017/7/19.
 */
public class NoOperandsInstruction implements JvmInstruction {
    @Override
    public void fetchOperands(JvmBytecodeReader jvmBytecodeReader) {

    }

    @Override
    public void execute(JvmFrame jvmFrame) {

    }
}
