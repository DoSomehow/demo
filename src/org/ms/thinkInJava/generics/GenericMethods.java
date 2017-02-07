package org.ms.thinkInJava.generics;

/**
 * Created by Administrator on 2017/1/18.
 */
public class GenericMethods {

    //泛型方法   注意，是将泛型参数列表置于“返回值”之前
    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }

}
