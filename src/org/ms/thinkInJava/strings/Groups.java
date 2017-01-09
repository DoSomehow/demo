package org.ms.thinkInJava.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/1/8.
 */
public class Groups {
    public static final String POEM =
            "Twas brillig, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" +
            "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" +
            "Beware the Jabberwock, my son,\n" +
            "The jaws the bite, the claws that catch.\n" +
            "Beware the Jubjub bird, and shun\n" +
            "The frumious Bandersnatch.";

    public static void main(String[] args) {
        //如果去掉了$，那么就会每三个单词，完成一次匹配，而不是每行最后三个单词完成匹配
        //如果去掉了模式标记(?m)，那么就只会输出一条结果，即 [The frumious Bandersnatch.][The][frumious Bandersnatch.][frumious][Bandersnatch]
        Pattern p = Pattern.compile("（?m）(\\S+)\\s+((\\S+)\\s+(\\S+))$");
        Matcher m = p.matcher(POEM);
        while(m.find()){
            for(int j = 0; j <= m.groupCount(); j++)  //注意这里是小于等于
                System.out.print("[" + m.group(j) + "]");
            System.out.println();
        }
        // System.out.println(POEM);
    }
}
