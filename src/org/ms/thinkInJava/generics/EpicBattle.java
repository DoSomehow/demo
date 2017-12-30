package org.ms.thinkInJava.generics;

import java.util.List;

/**
 * Created by Ryan on 2017/10/23.
 */
public class EpicBattle {
    //Bounds in generic methods:
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoises();
    }
    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);

        //You can do this:
        List<? extends SuperHearing> audioBoys;

        //But you can't do this:
        // List<? extends SuperHearing & SuperSmell> dogBoys;
    }
}
