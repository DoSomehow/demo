package org.ms.thinkInJava.typeinfo.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/1/12.
 */
public class Part {

    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        //Collections.addAll() gives an "unchecked generic array creation ... for varargs parameter" warning
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

}
