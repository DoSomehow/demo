package org.ms.tool.echarts;

import java.util.Random;
import java.util.StringJoiner;

/**
 * @author Ryan
 * @date 2021/4/7 15:35
 */
public class CreateSeriesData {

    public static void main(String[] args) {
        one();
    }

    /*
     * 生成 [m,n] 的数字
     * int i1 = random.nextInt() * (n-m+1)+m;
     */
    public static void one() {
        int days = 30;
        Random random = new Random();

        StringJoiner storageSj = new StringJoiner(",", "[", "]");
        StringJoiner distSj = new StringJoiner(",", "[", "]");
        StringJoiner remainSj = new StringJoiner(",", "[", "]");
        for (int i = 0; i < days; i++) {
            int storage = (int)(random.nextDouble() * (5000 - 4000 + 1) + 4000);  //4000~5000
            int dist = (int)(random.nextDouble() * (4500 - 3500 + 1) + 3500);  //3500~4500
            dist = i > 20 ? 0 : dist;  //20号之后不配送
            int remain = storage - dist;
            storageSj.add(String.valueOf(storage));
            distSj.add(String.valueOf(dist));
            remainSj.add(String.valueOf(remain));
        }
        System.out.println(storageSj.toString());
        System.out.println(distSj.toString());
        System.out.println(remainSj.toString());
    }

}
