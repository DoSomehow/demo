package org.ms.thinkInJava.generics;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/11.
 */
public class Aisle extends ArrayList<Shelf> {

    public Aisle(int nShelfs, int nProducts){
        for (int i = 0; i < nShelfs; i++){
            add(new Shelf(nProducts));
        }
    }

}
