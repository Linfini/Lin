package com.lin.command1;

public enum Visibility {
    //
    ViSIBLE("visible"), INVISIBLE("invisible");
    private String title;

    Visibility(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
