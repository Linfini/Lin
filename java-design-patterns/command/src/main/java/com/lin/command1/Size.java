package com.lin.command1;

public enum Size {
    //
    SMALL("small"), NORMAL("normal");

    private String title;

    Size(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return title;
    }
}
