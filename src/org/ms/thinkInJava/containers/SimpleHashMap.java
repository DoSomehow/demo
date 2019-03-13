package org.ms.thinkInJava.containers;

import org.ms.thinkInJava.util.Countries;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    //Choose a prime number for the hash table size, to archive a uniform distribution:
    static final int SIZE = 997;  //事实证明，质数实际上并不是散列桶的理想容量。近来，（经过广泛的测试）Java的散列函数的都使用2的整数次方。

    //You can't have a physical array of generics, but you can upcast to one:
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null){
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K, V> iPair = it.next();
            if(iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);  //Replace old with new
                found = true;
                break;
            }
        }
        if(!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null)
            return null;

        for(MapEntry<K, V> iPair : buckets[index]){
            if(iPair.getKey().equals(key)){
                return iPair.getValue();
            }
        }
        return null;
    }

    public Set<Entry<K, V>> entrySet(){
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets){
            if(bucket == null)
                continue;
            for (MapEntry<K, V> mPair : bucket){
                set.add(mPair);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }


}
