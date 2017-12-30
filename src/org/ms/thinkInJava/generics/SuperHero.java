package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class SuperHero<POWER extends SuperPower> {
    POWER power;
    SuperHero(POWER power){
        this.power = power;
    }

    POWER getPower(){
        return power;
    }
}
