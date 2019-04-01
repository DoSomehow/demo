package org.ms.thinkInJava.annotations;

import org.ms.thinkInJava.atunit.Test;
import org.ms.thinkInJava.util.OSExecute;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/31 22:32
 */
public class AtUnitExample1 {

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean m2() {
        return methodTwo() == 2;
    }

    @Test
    private boolean m3() {
        return true;
    }

    //Shows output for failure:
    @Test
    boolean failureTest() {
        return false;
    }

    @Test
    boolean anotherDisappointment() {
        return false;
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command("java net.mindView.atunit.AtUnit AtUnitExample1");
    }

}
