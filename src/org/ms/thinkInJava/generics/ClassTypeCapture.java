package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/19.
 */
public class ClassTypeCapture<T> {

    Class<T> kind;

    public ClassTypeCapture(Class<T> kind){
        this.kind = kind;
    }

    public boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctc1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctc1.f(new Building()));  //true
        System.out.println(ctc1.f(new House()));  //true

        ClassTypeCapture<House> ctc2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctc2.f(new Building()));  //false
        System.out.println(ctc2.f(new House()));  //true

        //Building obj = (Building)(new House());
        //House obj2 = (House)(new Building());  //error  //父类不能转子类的

    }

}
