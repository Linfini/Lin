package com.lin.ivorytower;

public enum EnumIvoryTower {
    //instance
    INSTANCE;

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }

}
