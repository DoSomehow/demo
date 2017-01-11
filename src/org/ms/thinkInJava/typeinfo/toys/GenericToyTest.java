package org.ms.thinkInJava.typeinfo.toys;

/**
 * Created by Administrator on 2017/1/10.
 */
public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();  //产生具体类型
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // Class<Toy> up2 = ftClass.getSuperclass();  //不会编译
        Object obj = up.newInstance();  //只能产生Object
    }
}
