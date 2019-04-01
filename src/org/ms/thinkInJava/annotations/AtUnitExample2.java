package org.ms.thinkInJava.annotations;

import org.ms.thinkInJava.atunit.Test;
import org.ms.thinkInJava.util.OSExecute;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/31 22:44
 */
public class AtUnitExample2 {

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    void asertExample() {
        assert methodOne().equals("This is methodOne");
    }

    @Test
    void assertFailureExample() {
        assert 1 == 2 : "What a surprise!";
    }

    @Test
    void exceptionExample() throws IOException {
        new FileInputStream("nofile.txt");  //Throws
    }

    @Test
    boolean assertAndReturn() {
        //Assertion with message:
        assert  methodTwo() == 2 : "methodTwo must equal 2";
        return methodOne().equals("This is methodOne");
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command("java net.mindView.atunit.AtUnit AtUnitExample2");
    }

}
