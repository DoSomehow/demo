package org.ms.thinkInJava.typeinfo.factory;

/**
 * Created by Administrator on 2017/1/12.
 */
public class FuelFilter extends Filter {
    public static class Factory implements org.ms.thinkInJava.typeinfo.factory.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
