package org.ms.thinkInJava.generics.coffee;

import org.ms.thinkInJava.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Administrator on 2017/1/16.
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {  //注意Iterable接口类中使用default关键字实现的方法，这是jdk1.8之后引入的
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private static Random rand = new Random(47);
    public CoffeeGenerator(){ }

    //For iteration(迭代):
    private int size = 0;
    public CoffeeGenerator(int sz){
        size = sz;
    }
    @Override
    public Coffee next(){
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;
        public boolean hasNext(){
            return count > 0;
        }
        public Coffee next(){
            count--;
            return CoffeeGenerator.this.next();
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++){
            System.out.println(gen.next());
        }
        for(Coffee c : new CoffeeGenerator(5)){  //CoffeeGenerator实现了Iterable接口，所以才可以在循环语句中使用
            System.out.println(c);
        }
    }
}
