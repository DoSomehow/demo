package org.ms.thinkInJava.enumerated;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/28 22:54
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
