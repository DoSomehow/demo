package org.ms.thinkInJava.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/1/2.
 */
public class LoggingException extends Exception {

    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

}
