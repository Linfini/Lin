package com.visitor;

public class App {

    public static void main(String[] args) {
        var commander =
                new Commander(new Sergeant(new Soldier(), new Soldier(), new Soldier()), new Sergeant(
                        new Soldier(), new Soldier(), new Soldier()));
        commander.accept(new SoldierVisitor());
        commander.accept(new SergeantVisitor());
        commander.accept(new CommanderVisitor());
    }
}
