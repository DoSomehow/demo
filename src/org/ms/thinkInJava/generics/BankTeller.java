package org.ms.thinkInJava.generics;

import java.util.*;

/**
 * Created by Administrator on 2017/3/29.
 */
public class BankTeller {
    public static void serve(Teller t, Customer c){
        System.out.println(t + "serves " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(26);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);  //这里获取generator和下边不一样哦

        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator, 4);

        for(Customer c : line){
            serve(tellers.get(rand.nextInt(tellers.size())), c);
        }
    }

}
