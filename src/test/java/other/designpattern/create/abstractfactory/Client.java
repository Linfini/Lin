package other.designpattern.create.abstractfactory;

import org.junit.Test;

/**
 * 抽象工厂模式
 *
 * 抽象工厂与工厂方法最大的区别就是IFactory 引入产品族,也就是说IFactory可以生产Product1 或者 Product2
 * 而使用工厂方法只能身长Product
 *
 * 而2.0排量车和2.4排量车则称为两个不同的产品族。再具体一点，2.0排量两厢车和2.4排量两厢车属于同一个等级结构，2.0排量三厢车和2.4排量三厢车属于另一个等级结构；而2.0排量两厢车和2.0排量三厢车属于同一个产品族，2.4排量两厢车和2.4排量三厢车属于另一个产品族。
 * 明白了等级结构和产品族的概念，就理解工厂方法模式和抽象工厂模式的区别了，如果工厂的产品全部属于同一个等级结构，则属于工厂方法模式；如果工厂的产品来自多个等级结构，则属于抽象工厂模式。
 * 在本例中，如果一个工厂模式提供2.0排量两厢车和2.4排量两厢车，那么他属于工厂方法模式；如果一个工厂模式是提供2.4排量两厢车和2.4排量三厢车两个产品，那么这个工厂模式就是抽象工厂模式，因为他提供的产品是分属两个不同的等级结构。当然，如果一个工厂提供全部四种车型的产品，因为产品分属两个等级结构，他当然也属于抽象工厂模式了。
 * */
public class Client {

    @Test
    public void test1(){
        IFactory factory=new Factory();
        IProduct1 product1 = factory.createProduct1();
        IProduct2 product2 = factory.createProduct2();
        product1.show();
        product2.show();
    }
}
