package com.zaki.jsontest;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.List;

public class toJavaObjectTest {

    @Test
    public void test() throws JSONException {
        String json = "{\"departmentName\":\"\",\"grossWeight\":\"\",\"piece\":\"件\",\"marker\":\"S\",\"PiProductLineName\":\"剑网3\",\"name\":\"T恤\",\"weight\":\"2.0\",\"shapeLength\":\"1.0\",\"barcode\":\"txu111\",\"shapeWidth\":\"1.0\",\"shapeHeight\":\"1.0\",\"piProductTypeName\":\"衣服\"}";
        PiProductDto piProductDto = JSONObject.parseObject(json, PiProductDto.class);
        System.out.println(piProductDto);
    }
    @Test
    public void test2(){

        String json2 = "{\"code\":\"sdasdas\",\"num\":\"2\"}";
        PiProductInputExcelDto piProductInputExcelDto = JSONObject.parseObject(json2, PiProductInputExcelDto.class);
        System.out.println(piProductInputExcelDto);
    }
}
