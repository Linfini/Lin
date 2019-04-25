package com.zaki.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class TokenInterceptor {

    @Pointcut("execution(* com.zaki.controller.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut() && ")
    public void verifyToken() {
        log.info("start verify token");
    }
}
