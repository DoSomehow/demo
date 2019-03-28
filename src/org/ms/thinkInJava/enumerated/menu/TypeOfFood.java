package org.ms.thinkInJava.enumerated.menu;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/26 23:30
 */
public class TypeOfFood {

    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.LASAGNE;
        food = Food.Dessert.GELATO;
        food = Food.Coffee.CAPPUCCINO;
        // System.out.println(food);
    }

}
