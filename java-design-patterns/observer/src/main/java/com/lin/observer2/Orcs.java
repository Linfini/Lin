package com.lin.observer2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * concreted Observer
 */
public class Orcs implements WeatherObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Orcs.class);

    @Override
    public void update(WeatherType currentWeather) {
        switch (currentWeather) {
            case COLD:
                LOGGER.info("The orcs are freeing cold");
                break;
            case RAINY:
                LOGGER.info("the orcs are driping wet.");
                break;
            case SUNNY:
                LOGGER.info("the sun hurts the orcs's eyes");
                break;
            case WINDY:
                LOGGER.info("the orc smell almost vanishes in the wind.");
                break;
            default:
                break;
        }
    }
}
