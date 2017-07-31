package com.nick.jvm.jvmaninstructionandexplain;

import com.nick.jvm.jvmaninstructionandexplain.comparisons.*;
import com.nick.jvm.jvmaninstructionandexplain.constants.Const;
import com.nick.jvm.jvmaninstructionandexplain.constants.Ipush;
import com.nick.jvm.jvmaninstructionandexplain.constants.Nop;
import com.nick.jvm.jvmaninstructionandexplain.control.Goto;
import com.nick.jvm.jvmaninstructionandexplain.control.LookupSwitch;
import com.nick.jvm.jvmaninstructionandexplain.control.TableSwitch;
import com.nick.jvm.jvmaninstructionandexplain.conversions.D2x;
import com.nick.jvm.jvmaninstructionandexplain.conversions.F2x;
import com.nick.jvm.jvmaninstructionandexplain.conversions.I2x;
import com.nick.jvm.jvmaninstructionandexplain.conversions.L2x;
import com.nick.jvm.jvmaninstructionandexplain.extended.Wide;
import com.nick.jvm.jvmaninstructionandexplain.instruction.BaseInstruction;
import com.nick.jvm.jvmaninstructionandexplain.instruction.JvmInstruction;
import com.nick.jvm.jvmaninstructionandexplain.loads.Load;
import com.nick.jvm.jvmaninstructionandexplain.math.*;
import com.nick.jvm.jvmaninstructionandexplain.stack.Dup;
import com.nick.jvm.jvmaninstructionandexplain.stack.Pop;
import com.nick.jvm.jvmaninstructionandexplain.stack.Swap;
import com.nick.jvm.jvmaninstructionandexplain.stores.Store;
import com.sun.org.apache.bcel.internal.generic.DADD;

/**
 * Created by KangShuai on 2017/7/24.
 */
public class InstructionFactory {
    public static JvmInstruction newInstance(byte code) {
        switch (code) {
            case 0x00:
                return new Nop();
            case 0x01:
                return new Const.ACONST_NULL();
            case 0x02:
                return new Const.ICONST_M1();
            case 0x03:
                return new Const.ICONST_0();
            case 0x04:
                return new Const.ICONST_1();
            case 0x05:
                return new Const.ICONST_2();
            case 0x06:
                return new Const.ICONST_3();
            case 0x07:
                return new Const.ICONST_4();
            case 0x08:
                return new Const.ICONST_5();
            case 0x09:
                return new Const.LCONST_0();
            case 0x0a:
                return new Const.LCONST_1();
            case 0x0b:
                return new Const.FCONST_0();
            case 0x0c:
                return new Const.FCONST_1();
            case 0x0d:
                return new Const.FCONST_2();
            case 0x0e:
                return new Const.DCONST_0();
            case 0x0f:
                return new Const.DCONST_1();
            case 0x10:
                return new Ipush.BIPUSH();
            case 0x11:
                return new Ipush.SIPUSH();
            // case 0x12:
            // 	return &LDC{}
            // case 0x13:
            // 	return &LDC_W{}
            // case 0x14:
            // 	return &LDC2_W{}
            case 0x15:
                return new Load.ILOAD();
            case 0x16:
                return new Load.LLOAD();
            case 0x17:
                return new Load.FLOAD();
            case 0x18:
                return new Load.DLOAD();
            case 0x19:
                return new Load.ALOAD();
            case 0x1a:
                return new Load.ILOAD_0();
            case 0x1b:
                return new Load.ILOAD_1();
            case 0x1c:
                return new Load.ILOAD_2();
            case 0x1d:
                return new Load.ILOAD_3();
            case 0x1e:
                return new Load.LLOAD_0();
            case 0x1f:
                return new Load.LLOAD_1();
            case 0x20:
                return new Load.LLOAD_2();
            case 0x21:
                return new Load.LLOAD_3();
            case 0x22:
                return new Load.FLOAD_0();
            case 0x23:
                return new Load.FLOAD_1();
            case 0x24:
                return new Load.FLOAD_2();
            case 0x25:
                return new Load.FLOAD_3();
            case 0x26:
                return new Load.DLOAD_0();
            case 0x27:
                return new Load.DLOAD_1();
            case 0x28:
                return new Load.DLOAD_2();
            case 0x29:
                return new Load.DLOAD_3();
            case 0x2a:
                return new Load.ALOAD_0();
            case 0x2b:
                return new Load.ALOAD_1();
            case 0x2c:
                return new Load.ALOAD_2();
            case 0x2d:
                return new Load.ALOAD_3();
            // case 0x2e:
            // 	return iaload
            // case 0x2f:
            // 	return laload
            // case 0x30:
            // 	return faload
            // case 0x31:
            // 	return daload
            // case 0x32:
            // 	return aaload
            // case 0x33:
            // 	return baload
            // case 0x34:
            // 	return caload
            // case 0x35:
            // 	return saload
            case 0x36:
                return new Store.ISTORE();
            case 0x37:
                return new Store.LSTORE();
            case 0x38:
                return new Store.FSTORE();
            case 0x39:
                return new Store.DSTORE();
            case 0x3a:
                return new Store.ASTORE();
            case 0x3b:
                return new Store.ISTORE_0();
            case 0x3c:
                return new Store.ISTORE_1();
            case 0x3d:
                return new Store.ISTORE_2();
            case 0x3e:
                return new Store.ISTORE_3();
            case 0x3f:
                return new Store.LSTORE_0();
            case 0x40:
                return new Store.LSTORE_1();
            case 0x41:
                return new Store.LSTORE_2();
            case 0x42:
                return new Store.LSTORE_3();
            case 0x43:
                return new Store.FSTORE_0();
            case 0x44:
                return new Store.FSTORE_1();
            case 0x45:
                return new Store.FSTORE_2();
            case 0x46:
                return new Store.FSTORE_3();
            case 0x47:
                return new Store.DSTORE_0();
            case 0x48:
                return new Store.DSTORE_1();
            case 0x49:
                return new Store.DSTORE_2();
            case 0x4a:
                return new Store.DSTORE_3();
            case 0x4b:
                return new Store.ASTORE_0();
            case 0x4c:
                return new Store.ASTORE_1();
            case 0x4d:
                return new Store.ASTORE_2();
            case 0x4e:
                return new Store.ASTORE_3();
            // case 0x4f:
            // 	return iastore
            // case 0x50:
            // 	return lastore
            // case 0x51:
            // 	return fastore
            // case 0x52:
            // 	return dastore
            // case 0x53:
            // 	return aastore
            // case 0x54:
            // 	return bastore
            // case 0x55:
            // 	return castore
            // case 0x56:
            // 	return sastore
            case 0x57:
                return new Pop.POP();
            case 0x58:
                return new Pop.POP2();
            case 0x59:
                return new Dup.DUP();
            case 0x5a:
                return new Dup.DUP_X1();
            case 0x5b:
                return new Dup.DUP_X2();
            case 0x5c:
                return new Dup.DUP2();
            case 0x5d:
                return new Dup.DUP2_X1();
            case 0x5e:
                return new Dup.DUP2_X2();
            case 0x5f:
                return new Swap.SWAP();
            case 0x60:
                return new Add.IADD();
            case 0x61:
                return new Add.LADD();
            case 0x62:
                return new Add.FADD();
            case 0x63:
                return new Add.DADD();
            case 0x64:
                return new Sub.ISUB();
            case 0x65:
                return new Sub.LSUB();
            case 0x66:
                return new Sub.FSUB();
            case 0x67:
                return new Sub.DSUB();
            case 0x68:
                return new Mul.IMUL();
            case 0x69:
                return new Mul.LMUL();
            case 0x6a:
                return new Mul.FMUL();
            case 0x6b:
                return new Mul.DMUL();
            case 0x6c:
                return new Div.IDIV();
            case 0x6d:
                return new Div.LDIV();
            case 0x6e:
                return new Div.FDIV();
            case 0x6f:
                return new Div.DDIV();
            case 0x70:
                return new Rem.IREM();
            case 0x71:
                return new Rem.LREM();
            case 0x72:
                return new Rem.FREM();
            case 0x73:
                return new Rem.DREM();
            case 0x74:
                return new Neg.INEG();
            case 0x75:
                return new Neg.LNEG();
            case 0x76:
                return new Neg.FNEG();
            case 0x77:
                return new Neg.DNEG();
            case 0x78:
                return new Sh.ISHL();
            case 0x79:
                return new Sh.LSHL();
            case 0x7a:
                return new Sh.ISHR();
            case 0x7b:
                return new Sh.LSHR();
            case 0x7c:
                return new Sh.IUSHR();
            case 0x7d:
                return new Sh.LUSHR();
            case 0x7e:
                return new And.IAND();
            case 0x7f:
                return new And.LAND();
            case (byte) 0x80:
                return new Or.IOR();
            case (byte) 0x81:
                return new Or.LOR();
            case (byte) 0x82:
                return new Xor.IXOR();
            case (byte) 0x83:
                return new Xor.LXOR();
            case (byte) 0x84:
                return new Iinc.IINC();
            case (byte) 0x85:
                return new I2x.I2L();
            case (byte) 0x86:
                return new I2x.I2F();
            case (byte) 0x87:
                return new I2x.I2D();
            case (byte) 0x88:
                return new L2x.L2I();
            case (byte) 0x89:
                return new L2x.L2F();
            case (byte) 0x8a:
                return new L2x.L2D();
            case (byte) 0x8b:
                return new F2x.F2I();
            case (byte) 0x8c:
                return new F2x.F2L();
            case (byte) 0x8d:
                return new F2x.F2D();
            case (byte) 0x8e:
                return new D2x.D2I();
            case (byte) 0x8f:
                return new D2x.D2L();
            case (byte) 0x90:
                return new D2x.D2F();
            //TODO
//            case 0x91:
//                return i2b
//            case 0x92:
//                return i2c
//            case 0x93:
//                return i2s
            case (byte) 0x94:
                return new Lcmp.LCMP();
            case (byte) 0x95:
                return new Fcmp.FCMPL();
            case (byte) 0x96:
                return new Fcmp.FCMPG();
            case (byte) 0x97:
                return new Dcmp.DCMPL();
            case (byte) 0x98:
                return new Dcmp.DCMPG();
            case (byte) 0x99:
                return new Ifcond.IFEQ();
            case (byte) 0x9a:
                return new Ifcond.IFNE();
            case (byte) 0x9b:
                return new Ifcond.IFLT();
            case (byte) 0x9c:
                return new Ifcond.IFGE();
            case (byte) 0x9d:
                return new Ifcond.IFGT();
            case (byte) 0x9e:
                return new Ifcond.IFLE();
            case (byte) 0x9f:
                return new IfIcmp.IF_ICMPEQ();
            case (byte) 0xa0:
                return new IfIcmp.IF_ICMPNE();
            case (byte) 0xa1:
                return new IfIcmp.IF_ICMPLT();
            case (byte) 0xa2:
                return new IfIcmp.IF_ICMPGE();
            case (byte) 0xa3:
                return new IfIcmp.IF_ICMPGT();
            case (byte) 0xa4:
                return new IfIcmp.IF_ICMPLE();
            case (byte) 0xa5:
                return new IfAcmp.IF_ACMPEQ();
            case (byte) 0xa6:
                return new IfAcmp.IF_ACMPNE();
            case (byte) 0xa7:
                return new Goto.GOTO();
            // case 0xa8:
            // 	return &JSR{}
            // case 0xa9:
            // 	return &RET{}
            case (byte) 0xaa:
                return new TableSwitch.TABLESWITCH();
            case (byte) 0xab:
                return new LookupSwitch.LOOKUP_SWITCH();
            // case 0xac:
            // 	return ireturn
            // case 0xad:
            // 	return lreturn
            // case 0xae:
            // 	return freturn
            // case 0xaf:
            // 	return dreturn
            // case 0xb0:
            // 	return areturn
            // case 0xb1:
            // 	return _return
            //	case 0xb2:
            //		return &GET_STATIC{}
            // case 0xb3:
            // 	return &PUT_STATIC{}
            // case 0xb4:
            // 	return &GET_FIELD{}
            // case 0xb5:
            // 	return &PUT_FIELD{}
            //	case 0xb6:
            //		return &INVOKE_VIRTUAL{}
            // case 0xb7:
            // 	return &INVOKE_SPECIAL{}
            // case 0xb8:
            // 	return &INVOKE_STATIC{}
            // case 0xb9:
            // 	return &INVOKE_INTERFACE{}
            // case 0xba:
            // 	return &INVOKE_DYNAMIC{}
            // case 0xbb:
            // 	return &NEW{}
            // case 0xbc:
            // 	return &NEW_ARRAY{}
            // case 0xbd:
            // 	return &ANEW_ARRAY{}
            // case 0xbe:
            // 	return arraylength
            // case 0xbf:
            // 	return athrow
            // case 0xc0:
            // 	return &CHECK_CAST{}
            // case 0xc1:
            // 	return &INSTANCE_OF{}
            // case 0xc2:
            // 	return monitorenter
            // case 0xc3:
            // 	return monitorexit
            case (byte) 0xc4:
                return new Wide.WIDE();
            // case 0xc5:
            // 	return &MULTI_ANEW_ARRAY{}
//            case 0xc6:
//                return new IFNULL
//            case 0xc7:
//                return new IFIFNONNULL{}
            case (byte) 0xc8:
                return new Goto.GOTO();
            // case 0xc9:
            // 	return &JSR_W{}
            // case 0xca: breakpoint
            // case 0xfe: impdep1
            // case 0xff: impdep2
        }
        return new BaseInstruction();
    }
}
