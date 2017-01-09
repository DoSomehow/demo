package org.ms.thinkInJava.exceptions;

/**
 * Created by Administrator on 2017/1/2.
 */
public class LoggingExceptions {

    public static void main(String[] args){
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught1 " + e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught2 " + e);
        }

    }

}
