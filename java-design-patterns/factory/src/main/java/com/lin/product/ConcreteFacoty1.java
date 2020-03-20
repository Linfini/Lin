package com.lin.product;

public class ConcreteFacoty1 implements AbstractFactory {

    @Override
    public Product newProduct() {
        System.out.println("具体共产1生成->具体产品1");
        return new ConcreteProduct1();
    }
}
