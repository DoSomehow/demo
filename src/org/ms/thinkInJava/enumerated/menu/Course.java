package org.ms.thinkInJava.enumerated.menu;

import org.ms.thinkInJava.util.Enums;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/26 23:32
 */
public enum Course {

    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }

}
