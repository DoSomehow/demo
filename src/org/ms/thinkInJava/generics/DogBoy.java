package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class DogBoy extends CanineHero<SuperHearSmell> {
    DogBoy(){
        super(new SuperHearSmell());
    }
}
