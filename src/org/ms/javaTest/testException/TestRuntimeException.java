package org.ms.javaTest.testException;

/**
 * Created by Ryan on 2017/12/28.
 */
public class TestRuntimeException {

    public static void main(String[] args) {

        try{
            System.out.println("start");
            throw new RuntimeException("exception occur");

        }catch (RuntimeException e){
            System.out.println("catch");
            System.out.println(e.getMessage());
        }finally{
            System.out.println("finally");
        }


    }
}
