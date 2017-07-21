package com.nick.jvm.jvmaninstructionandexplain;

import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;

/**
 * BranchInstruction表示跳转指令，Offset字段存放跳转偏移量。
 * FetchOperands（）方法从字节码中读取一个uint16整数，转成int后赋
 * 给Offset字段
 * Created by KangShuai on 2017/7/19.
 */
public class BranchInstruction implements JvmInstruction {

    public U2 offset;

    @Override
    public void fetchOperands(JvmBytecodeReader jvmBytecodeReader) {
        offset = jvmBytecodeReader.readUint16();
    }

    @Override
    public void execute(JvmFrame jvmFrame) {

    }
}
