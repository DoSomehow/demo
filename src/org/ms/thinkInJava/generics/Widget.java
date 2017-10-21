package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/19.
 */
public class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}
