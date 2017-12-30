package org.ms.thinkInJava.generics;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/11.
 */
public class Shelf extends ArrayList<Product> {

    public Shelf(int nProducts){
        Generators.fill(this, Product.generator, nProducts);
    }

}
