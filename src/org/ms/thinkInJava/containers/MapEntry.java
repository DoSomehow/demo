package org.ms.thinkInJava.containers;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {

    private K key;
    private V value;
    public MapEntry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    public V setValue(V v){
        V result = value;  //这一行是干啥的？
        value = v;
        return result;
    }

    public int hashCode(){
        return (key == null ? 0 : key.hashCode() ^ (value == null ? 0 : value.hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MapEntry))
            return false;

        MapEntry me = (MapEntry)obj;
        return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                (value == null ? me.getValue() == null : value.equals(me.getValue()));
    }

    @Override
    public String toString() {
        return key + "+" + value;
    }
}
