package org.ms.thinkInJava.generics;

import org.ms.thinkInJava.typeinfo.pets.Cat;
import org.ms.thinkInJava.typeinfo.pets.Dog;
import org.ms.thinkInJava.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {

    public static void oldStylemethod(List probablyDogs){
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStylemethod(dogs1);

        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStylemethod(dogs2);
        }catch (Exception e){
            System.out.println(e);
        }

        //Derived types work fine:
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }

}
