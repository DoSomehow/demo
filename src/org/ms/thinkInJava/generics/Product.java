package org.ms.thinkInJava.generics;

import org.ms.thinkInJava.util.Generator;

import java.util.Random;

/**
 * Created by Administrator on 2017/4/11.
 */
public class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int IDnumber, String descr, double price){
        id = IDnumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    public void priceChange(double change){
        price += change;
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(26);
        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble()*1000.0) + 0.99);
        }
    };

}
