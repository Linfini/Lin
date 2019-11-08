package com.lin.sharp;

/**
 * 这其实是一个简单工厂的例子,简单工厂的问题在于,当新增一个产品的时候,工厂类的代码要改动.
 */
public class Demo {


    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();
        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();
        Shape squarf = shapeFactory.getShape("squarf");
        squarf.draw();
    }
}
