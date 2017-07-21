package com.nick.jvm.jvmaninstructionandexplain;

import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.model.type.U2;

import java.io.InputStream;

/**
 * 有一些指令需要访问运行时常量池，常量池索引由两字节操
 * 作数给出。把这类指令抽象成Index16Instruction结构体，用Index字
 * 段表示常量池索引。FetchOperands（）方法从字节码中读取一个
 * uint16整数，转成uint后赋给Index字段。
 * Created by KangShuai on 2017/7/19.
 */
public class Index16Instruction implements JvmInstruction {

    private int index;

    @Override
    public void fetchOperands(JvmBytecodeReader jvmBytecodeReader) {
        index = jvmBytecodeReader.readInt16().getValue();
    }

    @Override
    public void execute(JvmFrame jvmFrame) {

    }
}
