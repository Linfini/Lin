package com.visitor;

public class Soldier extends Unit {
    public Soldier(Unit... children) {
        super(children);
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visitorSoldier(this);
        super.accept(unitVisitor);
    }

    @Override
    public String toString() {
        return "soldier";
    }
}
