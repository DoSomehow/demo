package org.ms.thinkInJava.enumerated;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/27 21:54
 */
public enum ConstantSpecificMethod {

    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }

}
