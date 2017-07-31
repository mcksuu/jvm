package com.nick.jvm.jvmaninstructionandexplain.instruction;

import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * 存储和加载类指令需要根据索引存取局部变量表，索引由单
 * 字节操作数给出。把这类指令抽象成Index8Instruction结构体，用
 * Index字段表示局部变量表索引。FetchOperands（）方法从字节码中
 * 读取一个int8整数，转成uint后赋给Index字段。
 * Created by KangShuai on 2017/7/19.
 */
public class Index8Instruction implements JvmInstruction{

    public int index;

    @Override
    public void fetchOperands(JvmBytecodeReader jvmBytecodeReader) {
        index = jvmBytecodeReader.readInt8().getValue();
    }

    @Override
    public void execute(JvmFrame jvmFrame) {

    }
}
