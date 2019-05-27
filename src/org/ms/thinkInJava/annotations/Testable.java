package org.ms.thinkInJava.annotations;

import org.ms.thinkInJava.atunit.Test;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/29 0:04
 */
public class Testable {

    public void execute() {
        System.out.println("Executing...");
    }

    @Test
    void testExecute() {
        execute();
    }

}
