package org.ms.javaTest.concurrent;

import java.util.LinkedList;

public class TestSynchronizedOnMethod {

    private static LinkedList<String> dataList = new LinkedList<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    putData(String.valueOf(i));
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String data = getData();
                    if (data != null) {
                        System.out.println(data);
                    }
                }
            }
        });
        t2.start();
    }

    private synchronized static void putData(String data) {
        dataList.add(data);
    }

    private synchronized static String getData(){
        String data = dataList.poll();
        return data;
    }

}
