package com.lin.observer1;

public class Demo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        subject.setState(15);
        subject.setState(10);
    }
}
