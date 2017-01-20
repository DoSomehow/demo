package org.ms.thinkInJava.typeinfo.factory;

/**
 * Created by Administrator on 2017/1/12.
 */
public class AirFilter extends Filter {
    public static class Factory implements org.ms.thinkInJava.typeinfo.factory.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
