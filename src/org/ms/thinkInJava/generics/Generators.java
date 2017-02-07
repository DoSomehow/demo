package org.ms.thinkInJava.generics;

import org.ms.thinkInJava.generics.coffee.Coffee;
import org.ms.thinkInJava.generics.coffee.CoffeeGenerator;
import org.ms.thinkInJava.util.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Administrator on 2017/1/19.
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
        for(int i = 0; i < n; i++){
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for(Coffee c:coffee){
            System.out.print(c);
        }
        System.out.println();
        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for(int i:fnumbers){
            System.out.print(i + ", ");
        }
    }

}
