package other.designpattern.action.observer;

public class ConcreteObserver1 implements  Observer {
    @Override
    public void update() {
        System.out.println("觀察者1收到纖細,并進行處理");
    }
}
