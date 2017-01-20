package org.ms.testJava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */
public class TestRtnValType {
    public static void main(String[] args) {
        test();
    }

    public static List<String> test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("测试返回值类型");
        list.add("看方法返回值类型");
        list.add("是否可以是返回值真实类型的");
        list.add("基类");
        return list;
    }
}
