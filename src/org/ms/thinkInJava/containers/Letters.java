package org.ms.thinkInJava.containers;

import org.ms.thinkInJava.util.Generator;
import org.ms.thinkInJava.util.Pair;

import java.util.Iterator;

public class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer>{

    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Pair<Integer, String> next(){
        return new Pair<>(number++, "" + letter++);
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


}
