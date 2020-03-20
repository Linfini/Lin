package com.visitor;

public class Unit {

    private Unit[] children;

    public Unit(Unit... children) {
        this.children = children;
    }

    public void accept(UnitVisitor unitVisitor){
        for(var child:children){
            child.accept(unitVisitor);
        }
    }
}
