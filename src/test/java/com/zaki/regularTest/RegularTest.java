package com.zaki.regularTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {
    @Test
    public void test1(){
        Long beVisitedUserId = getId("2018-01-01");
        System.out.println(beVisitedUserId);
    }

    Long getId(String description){
        List<String> list=new ArrayList<>();
        String p="/(\\d{4})-(\\d{1,2})-(\\d{1,2})/";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(description);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        return Long.parseLong(list.get(1));
    }

}
