package org.ms.designMode.observerMode;

import java.util.Observer;

/**
 * Created by Administrator on 2017/1/17 0017.
 */
public class Test {
    public static void main(String[] args) {
        Watched watched = new Watched();
        Observer watcher = new Watcher(watched);
        watched.setData("start");
        watched.setData("run");
        watched.setData("stop");
    }
}
