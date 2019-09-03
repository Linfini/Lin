package other.designpattern.action.iterator;

import org.junit.Test;

public class Client {

    @Test
    public void test() {
        Aggregate aggregate = new ConcreteAppregate();
        aggregate.add("小明");
        aggregate.add("小红");
        aggregate.add("小刚");
        Iterator it = aggregate.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            System.out.println(str);
        }
    }
}
