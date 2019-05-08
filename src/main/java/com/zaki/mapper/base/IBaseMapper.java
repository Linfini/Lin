package com.zaki.mapper.base;

import com.zaki.model.enums.Table;
import com.zaki.utils.DataUtils;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author argen
 */
public interface IBaseMapper<DOAMIN, ID> {
    String TABLE = tableName();

    int deleteByPrimaryKey(ID code);

    int insert(DOAMIN record);

    int insertSelective(DOAMIN record);

    DOAMIN selectByPrimaryKey(ID code);

    int updateByPrimaryKeySelective(DOAMIN record);

    int updateByPrimaryKey(DOAMIN record);

    @SelectProvider(type = UserSqlBuilder.class, method = "buildGetUserByName")
    List<DOAMIN> selectAll();

    List<DOAMIN> findRecordList(Class<DOAMIN> clazz, Map<String, Object> param);

    static String tableName() {
        return Table.Country.getTable();
    }

    class UserSqlBuilder {
        public static String buildGetUserByName() {
            return new SQL() {{
                SELECT("*");
                FROM(TABLE);
                ORDER_BY("name");
            }}.toString();
        }
    }
}
