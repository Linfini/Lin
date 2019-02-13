package other.generictest;

import org.junit.Test;

import java.util.ArrayList;

public class GenericTest {

    @Test
    public void test1(){
        Apple apple = new Apple();
        Orange orange = new Orange();
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(apple);
        fruits.add(orange);
        System.out.println(fruits);
    }
}
