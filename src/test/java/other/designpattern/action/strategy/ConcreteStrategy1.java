package other.designpattern.action.strategy;

public class ConcreteStrategy1 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("策略实现1");
    }
}
