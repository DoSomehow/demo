package org.ms.thinkInJava.typeinfo;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/1/15.
 */
public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);  //i = 1, I'm totally safe, Am i safe?
        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("f.getInt(pf): " + f.getInt(pf));  //f.getInt(pf): 1
        f.setInt(pf, 47);
        System.out.println(pf);  //i = 47, I'm totally safe, Am i safe?
        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(pf): " + f.get(pf));  //f.get(pf): I'm totally safe
        f.set(pf, "No, you're not!");
        System.out.println(pf);  //i = 47, I'm totally safe, Am i safe?
        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("f.get(pf): " + f.get(pf));  //f.get(pf): Am i safe?
        f.set(pf, "No, you're not!");
        System.out.println(pf);  //i = 47, I'm totally safe, No, you're not!
    }
}
