package org.ms.thinkInJava.typeinfo;

/**
 * Created by Administrator on 2017/1/10.
 */
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House)b;
    }
}
