package com.nick.jvm;

import com.nick.jvm.cmd.Cmd;
import com.nick.jvm.entry.ClassPath;
import com.nick.jvm.jvmaninstructionandexplain.Interpreter;
import com.nick.jvm.jvmobj.JvmObject;
import com.nick.jvm.jvmruntimedata.JvmFrame;
import com.nick.jvm.jvmruntimedata.JvmLocalVars;
import com.nick.jvm.jvmruntimedata.JvmOperandStack;
import com.nick.jvm.model.classfile.ClassFile;
import com.nick.jvm.model.cpinfo.ConstantUtf8Info;
import com.nick.jvm.model.methodinfo.MethodInfo;

/**
 * Created by KangShuai on 2017/7/14.
 */
public class Main {

    public static void main(String[] args) {
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

//        if (cmd.xjreFlag) {
        ClassPath classPath = new ClassPath();
        classPath.readUserClasspath(cmd);
        ClassFile classFile = PrintClass.printClass(cmd);
        if (classFile != null) {
            MethodInfo[] methodInfos = classFile.methodInfos;
            for (MethodInfo methodInfo : methodInfos) {
                if (classFile.cpInfo[methodInfo.nameIndex.getValue()] instanceof ConstantUtf8Info) {
                    String bytesValue = ((ConstantUtf8Info) classFile.cpInfo[methodInfo.nameIndex.getValue() - 1]).bytesValue;
                    if (bytesValue.equals("main")) {
                        Interpreter.interpret(methodInfo);
                    }
                }
            }
        }
//            classPath.readBootAndExtClasspath(cmd);
//        }

//        JvmFrame jvmFrame = new JvmFrame(10, 10);
//        testLocalVars(jvmFrame.jvmLocalVars);
//        testOperandStack(jvmFrame.jvmOperandStack);

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
