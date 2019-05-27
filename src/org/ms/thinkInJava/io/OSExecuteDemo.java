package org.ms.thinkInJava.io;

import org.ms.thinkInJava.util.OSExecute;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/21 22:02
 */
public class OSExecuteDemo {

    public static void main(String[] args) {
        OSExecute.command("javap OSExecuteDemo");
        // OSExecute.command("mstsc");
        // OSExecute.command("cmd");
    }

}
