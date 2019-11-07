package com.lin.observer2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * concreted Observer
 * */
public class Hobbits implements WeatherObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hobbits.class);

    @Override
    public void update(WeatherType currentWeather) {
        switch (currentWeather){
            case COLD:
                LOGGER.info("the hobbits are shivering in the cold weather.");
                break;
            case RAINY:
                LOGGER.info("the hobbits look for cover from the rain.");
                break;
            case SUNNY:
                LOGGER.info("the happy hobbits bade in the warm sun.");
                break;
            case WINDY:
                LOGGER.info("the hobbits hold thir hats tightly in the windy weather");
                break;
            default:
                break;
        }
    }
}
