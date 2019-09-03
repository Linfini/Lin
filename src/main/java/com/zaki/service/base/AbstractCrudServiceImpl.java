package com.zaki.service.base;

import com.zaki.mapper.base.IBaseMapper;
import com.zaki.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AbstractCrudServiceImpl<DOMAIN, ID> implements CrudService<DOMAIN, ID> {


    @Autowired
    private IBaseMapper<DOMAIN, ID> baseMapper;


    @Override
    public List<DOMAIN> listByParam(Class<DOMAIN> clazz, Map<String, Object> param) {
        return baseMapper.findRecordList(clazz, param);
    }

    @Override
    public DOMAIN getById(ID code) {
        return baseMapper.selectByPrimaryKey(code);
    }

    @Override
    public List<DOMAIN> selectAll() {
        return baseMapper.selectAll();
    }
}
