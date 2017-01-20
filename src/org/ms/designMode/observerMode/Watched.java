package org.ms.designMode.observerMode;

import java.util.Observable;

/**
 * Created by Administrator on 2017/1/17 0017.
 */
public class Watched extends Observable {
    private String data = "";
    public String getData(){
        return data;
    }
    public void setData(String data){
        if(!this.data.equals(data)){
            this.data  = data;
            setChanged();
        }
        notifyObservers();
    }

}
