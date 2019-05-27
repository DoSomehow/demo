package org.ms.thinkInJava.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/18 0:37
 */
public class FailFast {

    public static void main(String[] args) {

        Collection<String> c = new ArrayList<String>();
        Iterator<String> it = c.iterator();
        c.add("An object");
        try{
            String s = it.next();
        }catch (ConcurrentModificationException e){
            //程序运行时发生了异常，因为在容器取得迭代器之后，又有东西被放入到了该容器中
            System.out.println(e);
        }


    }

}
