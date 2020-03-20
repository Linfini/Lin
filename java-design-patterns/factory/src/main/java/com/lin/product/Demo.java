package com.lin.product;

public class Demo {
    public static void main(String[] args) {
        Product p;
        AbstractFactory af=new ConcreteFacoty1();
        Product product = af.newProduct();
        product.show();
    }
}
