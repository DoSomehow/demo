package org.ms.thinkInJava.typeinfo.factory;

/**
 * Created by Administrator on 2017/1/12.
 */
public class GeneratorBelt extends Belt {
    public static class Factory implements org.ms.thinkInJava.typeinfo.factory.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}
