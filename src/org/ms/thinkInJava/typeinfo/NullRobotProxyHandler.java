package org.ms.thinkInJava.typeinfo;

import org.ms.thinkInJava.util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private Robot proxied = new NRobot();
    public NullRobotProxyHandler(Class<? extends Robot> type){
        nullName = type.getSimpleName() + " NullRobot";
    }
    private class NRobot implements Null, Robot{
        @Override
        public String name() {
            return nullName;
        }
        @Override
        public String model() {
            return nullName;
        }
        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}
