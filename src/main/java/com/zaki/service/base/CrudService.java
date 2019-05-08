package com.zaki.service.base;

import com.zaki.model.Country;

import java.util.List;
import java.util.Map;

public interface CrudService<DOMAIN,ID> {

    List<DOMAIN> listByParam(Class<DOMAIN> clazz, Map<String,Object> param);

    DOMAIN getById(ID code);

    List<DOMAIN> selectAll();
}
