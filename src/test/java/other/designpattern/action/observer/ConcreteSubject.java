package other.designpattern.action.observer;

public class ConcreteSubject extends Subject {
    @Override
    public void doSomething() {
        System.out.println("被观察者发生改变");
        this.notifyObserver();
    }
}
