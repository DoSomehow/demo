package org.ms.thinkInJava.annotations.database;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/29 22:08
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
