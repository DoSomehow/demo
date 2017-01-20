package org.ms.designMode.observerMode;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2017/1/17 0017.
 */
public class Watcher implements Observer{
    public Watcher(Observable o){
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("状态发生改变：" + ((Watched)o).getData());
    }
}
