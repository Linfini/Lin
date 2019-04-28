package com.zaki.mapper.base;

import com.zaki.model.Country;
import com.zaki.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseMapperImpl<DOAMIN, ID> implements IBaseMapper<DOAMIN, ID> {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int deleteByPrimaryKey(ID code) {
        return 0;
    }

    @Override
    public int insert(DOAMIN record) {
        return 0;
    }

    @Override
    public int insertSelective(DOAMIN record) {
        return 0;
    }

    @Override
    public DOAMIN selectByPrimaryKey(ID code) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(DOAMIN record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DOAMIN record) {
        return 0;
    }

    @Override
    public List<DOAMIN> selectAll() {
        return null;
    }

    @Override
    public List<DOAMIN> findRecordList(Class<DOAMIN> clazz, Map<String, Object> param) {
        param = DataUtils.conditionLowToUpper(param);
        String tableName = DataUtils.classNameLowToUpper(clazz);
        String whereField = " where 1 = 1";

        assert param != null;
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                whereField = whereField + " AND " + key + "= '" + value + "'";
            } else {
                whereField = whereField = whereField + " AND " + key + "=" + value;
            }
        }

        String sql = "SELECT * FROM `" + tableName + "` " + whereField;
        List<Map<String, String>> modelList = sqlSessionTemplate.selectList("findentitylist", sql);
        List<DOAMIN> beanList = new ArrayList<>();
        for (Map map : modelList) {
            DOAMIN bean = null;
            try {
                bean = clazz.newInstance();
                BeanUtils.populate(bean, map);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            beanList.add(bean);
        }
        return beanList;
    }
}
