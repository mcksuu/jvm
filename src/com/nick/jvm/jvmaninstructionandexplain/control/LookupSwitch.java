package com.nick.jvm.jvmaninstructionandexplain.control;

import com.nick.jvm.jvmaninstructionandexplain.instruction.BaseInstruction;
import com.nick.jvm.jvmaninstructionandexplain.BranchLogic;
import com.nick.jvm.jvmaninstructionandexplain.instruction.JvmBytecodeReader;
import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.model.type.U4;

/**
 * Created by KangShuai on 2017/7/21.
 */
public class LookupSwitch {
    public static class LOOKUP_SWITCH extends BaseInstruction {
        public U4 defaultOffset;
        public U4 npairs;
        public U4[] matchOffsets;

        @Override
        public void fetchOperands(JvmBytecodeReader jvmBytecodeReader) {
            jvmBytecodeReader.skipPadding();
            defaultOffset = jvmBytecodeReader.readInt32();
            npairs = jvmBytecodeReader.readInt32();
            matchOffsets = new U4[npairs.getValue() * 2];
            for (int i = 0; i < matchOffsets.length; i++) {
                matchOffsets[i] = jvmBytecodeReader.readInt32();
            }
        }

        @Override
        public void execute(JvmFrame jvmFrame) {
            int value = jvmFrame.jvmOperandStack.popInt();
            for (int i = 0; i < matchOffsets.length; i += 2) {
                if (matchOffsets[i].getValue() == value) {
                    BranchLogic.branch(jvmFrame, matchOffsets[i + 1].getValue());
                    return;
                }
            }

            BranchLogic.branch(jvmFrame, defaultOffset.getValue());
        }
    }
}
