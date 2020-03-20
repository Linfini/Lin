package com.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeleeStrategy implements DragonSlayingStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeleeStrategy.class);

    @Override
    public void execute() {
        LOGGER.info("with your excalibur you server the dragon's deal");
    }
}
