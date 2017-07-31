package com.nick.jvm.jvmaninstructionandexplain.math;

import com.nick.jvm.jvmaninstructionandexplain.instruction.BaseInstruction;
import com.nick.jvm.jvmaninstructionandexplain.instruction.JvmBytecodeReader;
import com.nick.jvm.jvmruntimedata.JvmFrame;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class Iinc {
    public static class IINC extends BaseInstruction {
        public int index;
        public int cont;

        @Override
        public void fetchOperands(JvmBytecodeReader jvmBytecodeReader) {
            index = jvmBytecodeReader.readInt8().getValue();
            cont = jvmBytecodeReader.readUint8().getValue();
        }

        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = jvmFrame.jvmLocalVars.getInt(index);
            value += cont;
            jvmFrame.jvmLocalVars.setInt(index, value);
        }
    }
}
