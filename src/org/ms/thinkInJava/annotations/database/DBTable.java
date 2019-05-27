package org.ms.thinkInJava.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/29 21:48
 */
@Target(ElementType.TYPE)  //Applies to classes only
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}
