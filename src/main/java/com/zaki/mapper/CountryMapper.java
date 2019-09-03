package com.zaki.mapper;

import com.zaki.mapper.base.IBaseMapper;
import com.zaki.model.Country;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CountryMapper<Country,String> extends IBaseMapper<Country,String> {

}