package com.huangfu.webservicetest.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class SpringBeanUtil implements BeanFactoryAware {
    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        SpringBeanUtil.beanFactory = beanFactory;
    }

    /**
     * 向Spring容器动态注册一个bean
     *
     * @param beanName       bean名称
     * @param beanDefinition bean定义
     */
    public static void registeredBean(String beanName, BeanDefinition beanDefinition) {
        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition(beanName, beanDefinition);
    }

    /**
     * 向Spring容器动态注册一个bean
     *
     * @param beanName bean名称
     * @param bean     bean定义
     */
    public static void registeredBean(String beanName, Object bean) {
        ((DefaultListableBeanFactory) beanFactory).registerSingleton(beanName, bean);
    }

    /**
     * 取消注册bean
     *
     * @param beanName 要取消的名称
     */
    public static void deRegisteredBean(String beanName) {
        ((DefaultListableBeanFactory) beanFactory).destroySingleton(beanName);
    }
}
