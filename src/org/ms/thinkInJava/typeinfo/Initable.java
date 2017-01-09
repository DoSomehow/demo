package org.ms.thinkInJava.typeinfo;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Administrator on 2017/1/9.
 */
public class Initable {
    public static final int staticFinal = 47;
    public static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}
