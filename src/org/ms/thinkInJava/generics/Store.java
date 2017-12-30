package org.ms.thinkInJava.generics;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/11.
 */
public class Store extends ArrayList<Aisle> {

    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts){
        for(int i = 0; i < nAisles; i++){
            add(new Aisle(nShelves, nProducts));
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Aisle a : this){
            for(Shelf s : a){
                for(Product p : s){
                    sb.append(p);
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(14, 5, 10));
    }

}
