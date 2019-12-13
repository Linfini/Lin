package com.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoldierVisitor implements UnitVisitor {


    private static final Logger LOGGER = LoggerFactory.getLogger(SoldierVisitor.class);

    @Override
    public void visitorSoldier(Soldier soldier) {
        LOGGER.info("greetings {}", soldier);
    }

    @Override
    public void visitorSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitorCommander(Commander commander) {

    }
}
