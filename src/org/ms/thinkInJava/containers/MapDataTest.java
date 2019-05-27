package org.ms.thinkInJava.containers;

import org.ms.thinkInJava.util.CountingGenerator;
import org.ms.thinkInJava.util.MapData;
import org.ms.thinkInJava.util.RandomGenerator;

public class MapDataTest {

    public static void main(String[] args) {
        //Pair Generator:
        System.out.println(MapData.map(new Letters(), 11));
        //Two separate Generators:
        System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));
        //A key Generator and a single value:
        System.out.println(MapData.map(new CountingGenerator.Character(), "Value", 6));
        //An Iterable and a value Generator:
        System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
        //An Iterable and a single value:
        System.out.println(MapData.map(new Letters(), "Pop"));

    }

}
