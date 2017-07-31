package com.nick.jvm.jvmaninstructionandexplain.control;

import com.nick.jvm.jvmaninstructionandexplain.instruction.BaseInstruction;
import com.nick.jvm.jvmaninstructionandexplain.BranchLogic;
import com.nick.jvm.jvmaninstructionandexplain.instruction.JvmBytecodeReader;
import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.model.type.U4;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class TableSwitch {
    public static class TABLESWITCH extends BaseInstruction {
        public U4 defaultOffset;
        public U4 low;
        public U4 hight;
        public U4[] jumpOffsets;

        @Override
        public void fetchOperands(JvmBytecodeReader jvmBytecodeReader) {
            jvmBytecodeReader.skipPadding();
            defaultOffset = jvmBytecodeReader.readInt32();
            low = jvmBytecodeReader.readInt32();
            hight = jvmBytecodeReader.readInt32();
            int count = hight.getValue() - low.getValue() + 1;
            jumpOffsets = new U4[count];
            for (int i = 0; i < jumpOffsets.length; i++) {
                jumpOffsets[i] = jvmBytecodeReader.readInt32();
            }
        }

        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = jvmFrame.jvmOperandStack.popInt();
            int offset;
            if (value >= low.getValue() && value <= hight.getValue()) {
                offset = jumpOffsets[value - low.getValue()].getValue();
            } else {
                offset = defaultOffset.getValue();
            }

            BranchLogic.branch(jvmFrame, offset);
        }
    }
}
