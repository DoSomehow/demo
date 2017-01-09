package org.ms.thinkInJava.typeinfo.toys;

/**
 * Created by Administrator on 2017/1/8.
 */
public class ToyTest {
    public static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + "  is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("org.ms.thinkInJava.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FacnyToy");
            System.exit(1);
        }
        // printInfo(c);
        // for(Class face:c.getInterfaces()){
        //     printInfo(face);
        // }

        Class up = c.getSuperclass();
        printInfo(up);  //可以直接使用up
        Object obj = null;
        try {
            obj = up.newInstance();  //必须由默认构造器才可以使用该方法
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        // printInfo(obj.getClass());

        System.out.println(up == obj.getClass());

    }
}
