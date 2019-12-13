package com.service;

import com.zaki.Application;
import com.zaki.service.listener.EmailSendEvent;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

/***
 *
 * 在spring 中实现观察者模式非常简单 只需要继承ApplicationListener
 * */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MailSendTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Test
    public void testListener() {

        EmailSendEvent event = new EmailSendEvent("object", "abc@qq.com", "zhangsan", "This is the content");
        webApplicationContext.publishEvent(event);
    }
}