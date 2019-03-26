package org.ms.thinkInJava.io;

import java.util.prefs.Preferences;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/26 21:25
 */
public class PreferencesDemo {

    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);

        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;  //每跑一次main方法，这个会加一次1，又由于存储到了操作系统中，所以会看到这个值一直增加
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys()) {
            System.out.println(key + ": " + prefs.get(key, null));
        }
        //You must always provide a default value:
        System.out.println("How many companions does Dorothy have? " + prefs.getInt("Companions", 0));

    }

}
