package com.zaki.mapper;

import com.zaki.model.Country;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CountryMapper {
    int deleteByPrimaryKey(String code);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);

    @Select("select * from country")
    List<Country> selectAll();
}