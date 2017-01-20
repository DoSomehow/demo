package org.ms.thinkInJava.typeinfo.factory;

/**
 * Created by Administrator on 2017/1/12.
 */
public class OilFilter extends Filter {
    public static class Factory implements org.ms.thinkInJava.typeinfo.factory.Factory<OilFilter> {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}
