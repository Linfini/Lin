package com.zaki.service.base;

import com.zaki.Application;
import com.zaki.mapper.CountryMapper;
import com.zaki.mapper.base.IBaseMapper;
import com.zaki.model.Country;
import com.zaki.service.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractCrudServiceImplTest {


    @Autowired
    private CountryService<Country, String> countryService;

    private CountryMapper countryMapper;

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void listByParam() {
        Map<String, Object> param = new HashMap<>();
        param.put("Continent", "Asia");
        countryService.listByParam(Country.class, param);
    }

    @Test
    public void getById() {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(IBaseMapper.class);
        Object aia = countryService.getById("AIA");
        System.out.println(aia);
    }

    @Test
    public void getAll() {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(IBaseMapper.class);
        List<Country> countries = countryService.selectAll();
        System.out.println(countries);
    }
}