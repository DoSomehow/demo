package org.ms.thinkInJava.typeinfo;

import org.ms.thinkInJava.util.Null;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/1/15.
 */
public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), new Class[]{ Null.class, Robot.class }, new NullRobotProxyHandler(type));
    }

    public static void main(String[] args) {
        Robot[] bots = { new SnowRemovalRobot("SnowBee"), newNullRobot(SnowRemovalRobot.class) };
        for (Robot bot:bots){
            Robot.Test.test(bot);
        }
    }
}
