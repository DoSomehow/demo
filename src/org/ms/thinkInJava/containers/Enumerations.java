package org.ms.thinkInJava.containers;

import org.ms.thinkInJava.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/18 23:42
 */
public class Enumerations {

    public static void main(String[] args) {
        Vector<String> v = new Vector<>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements()){
            System.out.print(e.nextElement() + ", ");
        }
        //Produce an Enumeration from a Collection:
        e = Collections.enumeration(new ArrayList<String>());
    }

}
