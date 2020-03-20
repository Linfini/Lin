package com.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SergeantVisitor implements UnitVisitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SergeantVisitor.class);

    @Override
    public void visitorSoldier(Soldier soldier) {

    }

    @Override
    public void visitorSergeant(Sergeant sergeant) {
        LOGGER.info("hello {}", sergeant);
    }

    @Override
    public void visitorCommander(Commander commander) {

    }
}
