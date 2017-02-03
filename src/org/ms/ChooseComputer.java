package org.ms;

import java.util.Random;

/**
 * Created by Administrator on 2017/1/30 0030.
 */
public class ChooseComputer {

    public static void main(String[] args) {
        ChooseComputer cc = null;
        for(int i = 0; i < 3; i ++){
            cc = new ChooseComputer();
            cc.test();
        }

    }

    public void test(){
        Random rand = new Random( );
        int[] arr = new int[]{3,4};
        int x = rand.nextInt(9999);
        int y = x % 2;
        System.out.println(x);
        System.out.println(arr[y]);
    }
}
