package org.ms.thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2017/10/26.
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        //Compile Error: incompatible types
        // List<Fruit> flist2 = new ArrayList<Apple>();

        //Wildcards allow covariance
        List<? extends Fruit> flist = new ArrayList<Apple>();
        //Compile Error: can't add any type of object
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); //Leagl but uninteresting
        // We know that it returns at least Fruit
        Fruit f = flist.get(0);

        //List<? extends Fruit>可以合法地指向一个List<Orange>。
        //一旦执行这种类型的向上转型，你就将丢失掉向其中传递任何对象的能力，甚至是传递Object也不行。
    }
}
