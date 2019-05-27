package org.ms.thinkInJava.enumerated;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/28 22:27
 */
public interface Item {

    Outcome compete(Item it);
    Outcome eval(Paper p);
    Outcome eval(Scissors s);
    Outcome eval(Rock r);

}
