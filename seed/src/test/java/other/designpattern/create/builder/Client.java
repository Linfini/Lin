package other.designpattern.create.builder;

import org.junit.Test;

/**
 * 建造者模式
 * 很像工厂方法模式,区别是多了个Director类 提供常用的产品组合
 * 抽象类Builder 建造者ConcreteBuilder,实现Builder,依赖Product Director关联Builder
 * */
public class Client {

    @Test
    public void test1() {

        Director director = new Director();
        Product product1 = director.getAProduct();
        product1.showProduct();

        Product product2 = director.getBProduct();
        product2.showProduct();

    }
}
