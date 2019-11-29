package com.lin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTroll implements Troll {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTroll.class);

    @Override
    public void attack() {
        LOGGER.info("the troll tries to grab you!");
    }

    @Override
    public int getAttackPower() {
        return 0;
    }

    @Override
    public void fleeBattle() {

    }
}
