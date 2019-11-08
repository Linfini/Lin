package com.lin.sharp;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (null == shapeType) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();

        } else if (shapeType.equalsIgnoreCase("squarf")) {
            return new Square();
        }
        return null;
    }
}
