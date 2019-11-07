package com.lin.observer3;

public interface Observer {
    String getName();
    void setName(String name);
    void help();
    void beAttacked(AllyControllerCenter acc);
}
