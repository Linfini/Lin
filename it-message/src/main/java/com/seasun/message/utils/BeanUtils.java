package com.seasun.message.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements ApplicationContextAware {
    private static Logger log = LoggerFactory.getLogger(BeanUtils.class);

    private static ApplicationContext applicationContext;

    private static void setAppContext(ApplicationContext appContext) {
        applicationContext = appContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setAppContext(applicationContext);
    }

    public static Object getBean(String beanName) {
        Object beanInstance;
        try {
            beanInstance = applicationContext.getBean(beanName);
        } catch (NoSuchBeanDefinitionException e) {
            log.info("Bean '{}' not be found", beanName);
            throw new IllegalArgumentException(beanName + " not found");
        }
        return beanInstance;
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        Object beanInstance = getBean(beanName);
        if (beanInstance == null) {
            throw new IllegalArgumentException(clazz.getName() + " not found");
        }
        return clazz.cast(beanInstance);
    }

    public static <T> T getBean(Class<T> clazz) {
        T beanInstance;
        try {
            beanInstance = applicationContext.getBean(clazz);
        } catch (NoSuchBeanDefinitionException e) {
            log.info("Bean '{}' not be found", clazz);
            throw new IllegalArgumentException(clazz.getName() + " not found");
        }
        return beanInstance;
    }
}
