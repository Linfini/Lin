package com.zaki.config.datasource;

/**
 * @author zaki
 */

public enum DataSourceType {
    //主库
    primary("springDataSource","主库"),
    //从库
    second("secondDataSource","从库");

    private String type;
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
