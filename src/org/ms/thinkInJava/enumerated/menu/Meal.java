package org.ms.thinkInJava.enumerated.menu;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/26 23:35
 */
public class Meal {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }

}
