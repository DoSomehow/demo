package org.ms.thinkInJava.containers;

import java.util.WeakHashMap;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/18 23:30
 */
public class CanonicalMapping {

    public static void main(String[] args) {
        int size = 10;
        //Or, choose size via the command line:
        if(args.length > 0){
            size = new Integer(args[0]);
        }

        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value  v = new Value(Integer.toString(i));
            if(i % 3  == 0){
                keys[i] = k; //Save as "real" references
            }
            map.put(k, v);
        }
        System.gc();
    }

}
