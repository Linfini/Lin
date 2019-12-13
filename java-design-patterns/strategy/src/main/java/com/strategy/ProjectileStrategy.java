package com.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectileStrategy implements DragonSlayingStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectileStrategy.class);

    @Override
    public void execute() {
        LOGGER.info("you shoot  the dragon with the magical crossbow and it falls dead on the ground");
    }
}
