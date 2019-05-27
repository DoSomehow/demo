package org.ms.thinkInJava.containers;

import org.ms.thinkInJava.holding.MapOfList;
import org.ms.thinkInJava.typeinfo.pets.Individual;
import org.ms.thinkInJava.typeinfo.pets.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IndividualTest {

    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<>();
        for (List<? extends Pet> lp : MapOfList.petPeople.values()){
            for (Pet p : lp){
                pets.add(p);
            }
        }
        System.out.println(pets);
    }

}
