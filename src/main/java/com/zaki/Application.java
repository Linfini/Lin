package com.zaki;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@MapperScan({"com.zaki.mapper"})
@EnableTransactionManagement
@ServletComponentScan
@EnableAsync
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
