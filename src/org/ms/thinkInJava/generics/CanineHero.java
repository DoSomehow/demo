package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER>{
    CanineHero(POWER power){
        super(power);
    }

    void hear(){
        power.hearSubtleNoises();
    }

    void smell(){
        power.trackBySmell();
    }
}
