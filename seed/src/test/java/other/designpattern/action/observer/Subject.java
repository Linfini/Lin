package other.designpattern.action.observer;

import java.util.Vector;

public abstract class Subject {
    private Vector<Observer> obs = new Vector<Observer>();

    public void addObserver(Observer ob) {
        this.obs.add(ob);
    }

    public void delObsServer(Observer ob){
        this.obs.remove(obs);
    }

    protected void notifyObserver(){
        for(Observer o:obs){
            o.update();
        }
    }

    public abstract void doSomething();
}
