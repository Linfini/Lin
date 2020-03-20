package com.lin.observer2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static  final Logger LOGGER= LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());

        weather.timePass();
        weather.timePass();
        weather.timePass();
        weather.timePass();

    }
}
