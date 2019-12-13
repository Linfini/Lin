package com.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommanderVisitor implements UnitVisitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommanderVisitor.class);

    @Override
    public void visitorSoldier(Soldier soldier) {

    }

    @Override
    public void visitorSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitorCommander(Commander commander) {
        LOGGER.info("good to see you {}", commander);
    }
}
