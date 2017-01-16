package org.ms.thinkInJava.typeinfo.packageaccess;

import org.ms.thinkInJava.typeinfo.interfacea.A;

/**
 * Created by Administrator on 2017/1/15.
 */
public class HiddenC {
    public static A makeA(){
        return new C();
    }
}
