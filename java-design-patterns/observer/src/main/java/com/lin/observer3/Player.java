package com.lin.observer3;

/**
 * concreted Observer
 */
public class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println("hold on," + this.name + "I will cover you!");
    }

    @Override
    public void beAttacked(AllyControllerCenter acc) {
        System.out.println(this.name + "be attacked!");
        acc.notifyObserver(this.name);
    }


}
