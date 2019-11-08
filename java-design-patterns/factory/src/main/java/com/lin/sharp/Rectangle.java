package com.lin.sharp;

/**
 * concrete production
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("inside rectangle:draw() method");
    }
}
