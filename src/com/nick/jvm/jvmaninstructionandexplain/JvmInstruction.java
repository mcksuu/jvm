package com.nick.jvm.jvmaninstructionandexplain;

import com.nick.jvm.jvmruntimedata.JvmFrame;

import java.io.InputStream;

/**
 * Created by KangShuai on 2017/7/19.
 */
public interface JvmInstruction {
    void fetchOperands(JvmBytecodeReader jvmBytecodeReader);
    void execute(JvmFrame jvmFrame);
}
