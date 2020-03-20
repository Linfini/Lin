package com.lin.observer1;

public abstract class Observer {
    public abstract void update();

    protected Subject subject;
}
