package com.lin.observer2.generic;


import com.lin.observer2.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GWeather extends Observable<GWeather, Race, WeatherType> {
    private static final Logger LOGGER = LoggerFactory.getLogger(GWeather.class);


    private WeatherType currentWeather;

    public GWeather() {
        currentWeather = WeatherType.SUNNY;
    }

    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        LOGGER.info("The wather changed to {}", currentWeather);
        notifyObservers(currentWeather);
    }
}
