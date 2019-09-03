package com.zaki.config.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zaki
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> LOCAL = new ThreadLocal<>();
    private static final List<String> DATA_SOURCE_IDS = new ArrayList<>();

    public static void usePrimary() {
        LOCAL.set(DataSourceType.primary.getType());
    }
    public static void useSecond() {
        LOCAL.set(DataSourceType.second.getType());
    }


    public static ThreadLocal<String> getLocal() {
        return LOCAL;
    }
    public static void setType(String type) {
        LOCAL.set(type);
    }
    public static String getJdbcType() {
        return LOCAL.get();
    }
    public static void clearDBType() {
        LOCAL.remove();
    }
    public static boolean containsDataSource(String dataSourceId) {
        return DATA_SOURCE_IDS.contains(dataSourceId);
    }
    public static void addDataSourceIds(String dataSourceId) {
        DATA_SOURCE_IDS.add(dataSourceId);
    }
}

