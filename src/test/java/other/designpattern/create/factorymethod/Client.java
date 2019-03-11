package other.designpattern.create.factorymethod;

import org.junit.Test;

/**
 * 工厂方法
 * 我觉得工厂方法是为了屏蔽产品的细节,做到new一个工厂就能产生对应的产品.但对于调用者不需要知道产品的参数
 * */
public class Client {

    @Test
    public void testFactoryMethod(){
        IFactory factory=new Factory();
        IProduct product = factory.createProduct();
        product.productMethod();
    }
}
