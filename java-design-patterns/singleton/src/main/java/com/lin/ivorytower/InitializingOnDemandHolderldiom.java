package com.lin.ivorytower;

public class InitializingOnDemandHolderldiom {

    public InitializingOnDemandHolderldiom() {
    }


    public static InitializingOnDemandHolderldiom getInstance() {
        return HelperHolder.INSTACE;
    }

    private static class HelperHolder {
        private static final InitializingOnDemandHolderldiom INSTACE = new InitializingOnDemandHolderldiom();
    }


}
