package com.nick.jvm;

import com.nick.jvm.cmd.Cmd;
import com.nick.jvm.entry.ClassPath;
import com.nick.jvm.jvmobj.JvmObject;
import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.jvmruntimedata.JvmLocalVars;
import com.nick.jvm.jvmruntimedata.JvmOperandStack;

/**
 * Created by KangShuai on 2017/7/14.
 */
public class Main {

    public static void main(String[] args) {

//        long a = 299792458011212L;
//        int b = (int) (a >> 32);
//        int c = (int) a;
//
//        System.out.println("a = " + Long.toBinaryString(a) + "\n" + "b = " + b + " " + Integer.toBinaryString(b) + "\n" + " c = " + c + " " + Integer.toBinaryString(c));
//        long d = (b & 0x000000ffffffffL) << 32;
//        long f = c & 0x00000000ffffffffL;
//        System.out.println(d | f);

        Cmd cmd = Cmd.parseCmd(args);
        if (cmd.helpFlag) {
            println("Usage: %s [-options] class [args...]", "Main");
        } else if (cmd.versionFlag) {
            println("Version 1.0.0");
        } else {
            startJVM(cmd);
        }
    }

    private static void startJVM(Cmd cmd) {
        String argsStr = "";
        if (cmd.cpFlag || cmd.clazzPathFlag) {
            for (String arg : cmd.args) {
                argsStr += arg + " ";
            }
            println("classpath:%s class:%s args:%s", cmd.clazzPath, cmd.clazz, argsStr);
        }

        if (cmd.xjreFlag) {
            ClassPath classPath = new ClassPath();
            classPath.readUserClasspath(cmd);
            PrintClass.printClass(cmd);
//            classPath.readBootAndExtClasspath(cmd);
        }

        JvmFrame jvmFrame = new JvmFrame(10, 10);
        testLocalVars(jvmFrame.jvmLocalVars);
        testOperandStack(jvmFrame.jvmOperandStack);

    }

    private static void testLocalVars(JvmLocalVars jvmLocalVars) {
        jvmLocalVars.setInt(0, 100);
        jvmLocalVars.setInt(1, -100);
        jvmLocalVars.setLong(2, 2997924580L);
        jvmLocalVars.setLong(4, -2997924580L);
        jvmLocalVars.setFloat(6, 3.1415926F);
        jvmLocalVars.setDouble(7, 2.71828182845d);
        jvmLocalVars.setRef(9, new JvmObject());
        println(jvmLocalVars.getInt(0));
        System.out.println();
        println(jvmLocalVars.getInt(1));
        System.out.println();
        println(jvmLocalVars.getLong(2));
        System.out.println();
        println(jvmLocalVars.getLong(4));
        System.out.println();
        println(jvmLocalVars.getFloat(6));
        System.out.println();
        println(jvmLocalVars.getDouble(7));
        System.out.println();
        println(jvmLocalVars.getRef(9));
        System.out.println();
    }

    private static void testOperandStack(JvmOperandStack jvmOperandStack) {
        jvmOperandStack.pushInt(100);
        jvmOperandStack.pushInt(-100);
        jvmOperandStack.pushLong(2997924580L);
        jvmOperandStack.pushLong(-2997924580L);
        jvmOperandStack.pushFloat(3.1415926f);
        jvmOperandStack.pushDouble(2.71828182845d);
        jvmOperandStack.pushRef(new JvmObject());
        println(jvmOperandStack.popRef());
        System.out.println();
        println(jvmOperandStack.popDouble());
        System.out.println();
        println(jvmOperandStack.popFloat());
        System.out.println();
        println(jvmOperandStack.popLong());
        System.out.println();
        println(jvmOperandStack.popLong());
        System.out.println();
        println(jvmOperandStack.popInt());
        System.out.println();
        println(jvmOperandStack.popInt());
        System.out.println();
    }

    public static void println(String f, String... s) {

        System.out.println(String.format(f, s));
    }

    public static void println(Object o) {
        System.out.print(o + " ");
    }
}
