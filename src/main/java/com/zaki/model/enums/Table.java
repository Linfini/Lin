package com.zaki.model.enums;

public enum  Table {
    //
    Country("country");

    private String table ;

    Table(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
