package com.templatemethod;

public class App {

    public static void main(String[] args) {
        var thief = new HalfingThief(new HitAndRunMethod());
        thief.steal();
        thief.changeMethod(new SubtleMethod());
        thief.steal();
    }
}
