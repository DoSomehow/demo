package org.ms.thinkInJava.enumerated;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/27 21:59
 */
public enum LikeClasses {

    WINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior1");
        }
    },
    BLINKEN{
        @Override
        void behavior() {
            System.out.println("Behavior2");
        }
    },
    NOD {
        @Override
        void behavior() {
            System.out.println("Behavior3");
        }
    };

    abstract void behavior();

}
