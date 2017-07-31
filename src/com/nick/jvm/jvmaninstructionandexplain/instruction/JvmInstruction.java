package com.nick.jvm.jvmaninstructionandexplain.instruction;

import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/19.
 */
public interface JvmInstruction {
    void fetchOperands(JvmBytecodeReader jvmBytecodeReader);
    void execute(JvmFrame jvmFrame);
}
