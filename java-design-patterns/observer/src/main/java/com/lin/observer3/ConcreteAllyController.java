package com.lin.observer3;

/**
 * concrete Subject
 *
 * */
public class ConcreteAllyController extends AllyControllerCenter {

    public ConcreteAllyController(String name) {
        System.out.println(name + "be created");
        this.allyName = name;
    }

    @Override
    public void notifyObserver(String name) {
        System.out.println(this.allyName + "warning:" + name + "is being attacked");
        for (Observer obs : players) {
            if (obs.getName().equalsIgnoreCase(name)) {
                obs.help();
            }
        }
    }
}
