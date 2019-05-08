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
public interface IBaseMapper<DOMAIN, ID> {
    String TABLE = tableName();

    int deleteByPrimaryKey(ID code);

    int insert(DOMAIN record);

    int insertSelective(DOMAIN record);

    DOMAIN selectByPrimaryKey(ID code);

    int updateByPrimaryKeySelective(DOMAIN record);

    int updateByPrimaryKey(DOMAIN record);

    @SelectProvider(type = UserSqlBuilder.class, method = "buildGetUserByName")
    List<DOMAIN> selectAll();

    List<DOMAIN> findRecordList(Class<DOMAIN> clazz, Map<String, Object> param);

    static String tableName() {
        return Table.Country.getTable();
    }

    class UserSqlBuilder {
        public static String buildGetUserByName() {
            return new SQL() {{
                SELECT("*");
                FROM(TABLE);
            }}.toString();
        }
    }
}
