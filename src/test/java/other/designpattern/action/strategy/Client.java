package other.designpattern.action.strategy;

import org.junit.Test;

public class Client {

    @Test
    public void test() {
        Context context;
        System.out.println("执行策略1");
        context = new Context(new ConcreteStrategy1());
        context.execute();

        System.out.println("执行策略2");
        context = new Context(new Concretestrategy2());
        context.execute();
    }
}
