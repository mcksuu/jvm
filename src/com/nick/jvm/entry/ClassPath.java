package com.nick.jvm.entry;

import com.nick.jvm.cmd.Cmd;
import com.nick.jvm.util.Utils;

import java.io.File;

/**
 * Created by KangShuai on 2017/7/17.
 */
public class ClassPath {
    public String bootClasspath;
    public String extClasspath;
    public String userClasspath;

    public void readBootAndExtClasspath(Cmd cmd) {
        String jreOption = cmd.xjreOption.replace("*", "");
        if (!Utils.isEmpty(jreOption)) {
            if (!new File(".\\jre").exists()) {
                jreOption = System.getenv("JAVA_HOME");
            } else {
                jreOption = "";
            }
        }

        String path = jreOption + ".\\jre\\lib\\*";
        if (Utils.isEmpty(jreOption)) {
            bootClasspath = path;
            Entry.newEntry(path).readClass();
        } else {
            bootClasspath = jreOption + "\\jre\\lib\\*";
            Entry.newEntry(bootClasspath).readClass();
        }

        if (Utils.isEmpty(jreOption)) {
            extClasspath = jreOption + ".\\jre\\lib\\ext";
            Entry.newEntry(path).readClass();
        } else {
            extClasspath = jreOption + "\\jre\\lib\\ext\\*";
            Entry.newEntry(extClasspath).readClass();
        }
    }

    public void readUserClasspath(Cmd cmd) {
        if (!Utils.isEmpty(cmd.clazzPath)) {
            userClasspath = cmd.clazzPath;
            Entry.newEntry(userClasspath + "\\" + cmd.clazz).readClass();
        } else {
            userClasspath = ".\\";
            Entry.newEntry(userClasspath + cmd.clazz).readClass();
        }
    }
}
