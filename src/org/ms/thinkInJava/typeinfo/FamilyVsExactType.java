package org.ms.thinkInJava.typeinfo;

/**
 * Created by Administrator on 2017/1/12.
 */
public class FamilyVsExactType {
    static void test(Object x){
        System.out.println("Testing x of type " + x.getClass());
        System.out.println("x instanceof Base _____" + (x instanceof Base));
        System.out.println("x instanceof Derived _____" + (x instanceof Derived));
        System.out.println("Base.isInstance(x) _____" + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x) _____" + Derived.class.isInstance(x));
        System.out.println("x.getClass() == Base.class _____" + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class _____" + (x.getClass() == Derived.class));
        System.out.println("x.getClass().equals(Base.class) _____" + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derived.class) _____" + (x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}
