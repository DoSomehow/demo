package org.ms.thinkInJava.generics;

import org.ms.thinkInJava.util.Generator;

/**
 * Created by Administrator on 2017/3/29.
 */
public class Teller {
    private static long counter = 1;
    private final long id = counter++;
    private Teller(){}  //私有构造函数
    public String toString(){
        return "Teller " + id;
    }

    //A single Generator object
    public static Generator<Teller> generator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };

}
