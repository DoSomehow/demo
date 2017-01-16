package org.ms.thinkInJava.typeinfo;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/1/13.
 */
public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        //Insert a proxy and call again:
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{ Interface.class }, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
