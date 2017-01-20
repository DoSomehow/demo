package org.ms.thinkInJava.typeinfo.factory;

/**
 * Created by Administrator on 2017/1/12.
 */
public class FanBelt extends Belt {
    public static class Factory implements org.ms.thinkInJava.typeinfo.factory.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
