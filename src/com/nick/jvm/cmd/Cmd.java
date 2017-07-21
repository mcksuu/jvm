package com.nick.jvm.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KangShuai on 2017/7/14.
 */
public class Cmd {

    public static final String HELP_FLAG = "-help";
    public static final String VERSION_FLAG = "-version";
    public static final String CP_OPTION = "-cp";
    public static final String CLAZZ = "-classpath";
    public static final String XJRE_OPTION = "-Xjre";

    public boolean helpFlag;
    public boolean versionFlag;
    public boolean cpFlag;
    public boolean clazzPathFlag;
    public boolean xjreFlag;
    public String cpOption;
    public String clazz;
    public String clazzPath;
    public String[] args;
    public String xjreOption;


    public static Cmd parseCmd(String[] args) {
        Cmd cmd = new Cmd();
        String op = args[0];
        if (op.equals(HELP_FLAG)) {
            cmd.helpFlag = true;
            return cmd;
        } else if (op.equals(VERSION_FLAG)) {
            cmd.versionFlag = true;
            return cmd;
        }

        List<String> argList = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(CP_OPTION) || args[i].equals(CLAZZ)) {
                cmd.cpFlag = true;
                cmd.clazzPathFlag = true;
                cmd.cpOption = CP_OPTION;
                cmd.clazzPath = args[i + 1];
                cmd.clazz = args[i + 2];

                for (int j = i + 3; j < args.length; j++) {
                    if (args[j].startsWith("-")) {
                        i = j;
                        break;
                    } else {
                        argList.add(args[j]);
                    }
                }

                cmd.args = new String[argList.size()];
                cmd.args = argList.toArray(cmd.args);
            }

            if (args[i].equals(XJRE_OPTION)) {
                cmd.xjreFlag = true;
                cmd.xjreOption = args[i + 1];
            } else {
                cmd.helpFlag = false;
            }
        }

        return cmd;
    }
}
