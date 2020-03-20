package com.templatemethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class StealingMethod {

    private static final Logger LOGGER = LoggerFactory.getLogger(StealingMethod.class);

    protected abstract String pickTarget();

    protected abstract void confuseTarget(String target);

    protected abstract void stealTheItem(String target);

    public void steal(){
        var target=pickTarget();
        LOGGER.info("the target has been chosen as {}",target);
        confuseTarget(target);
        stealTheItem(target);
    }
}
