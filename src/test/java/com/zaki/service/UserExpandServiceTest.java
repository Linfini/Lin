package com.zaki.service;

import com.zaki.Application;
import com.zaki.model.UserExpand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserExpandServiceTest {

    @Autowired(required = true)
    private UserExpandService userExpandService;

    @Test
    public void createUserExpand() {
        UserExpand user = new UserExpand();
        user.setId(1L);
        user.setUserName("张三");
        user.setProfile("一年级");

        int userExpand = userExpandService.createUserExpand(user);
    }
}