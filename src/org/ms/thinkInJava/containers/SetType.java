package org.ms.thinkInJava.containers;

public class SetType {

    int i;

    public SetType(int n){
        i = n;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && (i == ((SetType)obj).i);
    }

    public String toString(){
        return Integer.toString(i);
    }

}
