package org.ms.thinkInJava.generics;

import java.util.*;

/**
 * Created by Ryan on 2017/5/26.
 */
public class LostInfomation {

    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();

        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));

        //jdk文档描述：Class.getTypeParameters()将返回一个TypeVariable对象数组，表示有泛型声明所声明的类型参数......
        //但是根据上边例子的结果，能够发现的只是用作参数占位符的“标识符”，这并非有用的信息
        //因此，在泛型代码内部，无法获得任何有关泛型参数类型的信息

    }

}
