package com.lin.ivorytower;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        var ivoryTower1 = IvoryTower.getInstance();
        var ivoryTower2 = IvoryTower.getInstance();
        LOGGER.info("invoryTower1={}", ivoryTower1);
        LOGGER.info("invoryTower2={}", ivoryTower2);

        var threadSaftIvoryTower1 = ThreadSafeLazyLoadedIvoryTower.getInstance();
        var threadSafeIvoryTower2 = ThreadSafeLazyLoadedIvoryTower.getInstance();
        LOGGER.info("threadSafeIvoryTower1={}", threadSaftIvoryTower1);
        LOGGER.info("threadSafeIvoryTower2={}", threadSafeIvoryTower2);

        //enum singleton
        EnumIvoryTower enumIvoryTower1 = EnumIvoryTower.INSTANCE;
        EnumIvoryTower enumIvoryTower2 = EnumIvoryTower.INSTANCE;
        LOGGER.info("enumIvoryTower1={}", enumIvoryTower1);
        LOGGER.info("enumIvoryTower2={}", enumIvoryTower2);

        //double checked locking
        ThreadSafeDoubleCheckLocking dc1 = ThreadSafeDoubleCheckLocking.getInstance();
        ThreadSafeDoubleCheckLocking dc2 = ThreadSafeDoubleCheckLocking.getInstance();
        LOGGER.info(dc1.toString());
        LOGGER.info(dc2.toString());

        //initialize on demand holder idiom
        InitializingOnDemandHolderldiom demandHolderldiom = InitializingOnDemandHolderldiom.getInstance();
        LOGGER.info(demandHolderldiom.toString());
        InitializingOnDemandHolderldiom demandHolderIdiom2 = InitializingOnDemandHolderldiom.getInstance();
        LOGGER.info(demandHolderIdiom2.toString());
    }
}
