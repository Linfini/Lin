package com.lin.observer3;

import java.util.ArrayList;
import java.util.List;

/**
 * subject interface
 */
public abstract class AllyControllerCenter {
    protected String allyName;
    protected List<Observer> players = new ArrayList<>();

    public void join(Observer observer) {
        System.out.println(observer.getName() + "join" + this.allyName);
        players.add(observer);
    }

    public void quit(Observer observer) {
        System.out.println(observer.getName() + "out" + this.allyName);
        players.remove(observer);
    }

    public abstract void notifyObserver(String name);


    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }
}
