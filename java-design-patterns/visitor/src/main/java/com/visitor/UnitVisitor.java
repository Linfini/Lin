package com.visitor;

public interface UnitVisitor {
    void visitorSoldier(Soldier soldier);
    void visitorSergeant(Sergeant sergeant);
    void visitorCommander(Commander commander);
}
