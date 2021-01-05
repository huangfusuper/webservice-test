package com.huangfu.webservicetest.config;

import com.huangfu.webservicetest.annotation.WebserviceUrl;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * 自动增加webservice服务端点
 *
 * @author huangfu
 * @date 2021年1月5日08:18:29
 */
@DependsOn("springBus")
public class AutoWebServiceEndpoint implements BeanPostProcessor {
    private final SpringBus springBus;

    public AutoWebServiceEndpoint(SpringBus springBus) {
        this.springBus = springBus;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        boolean webServiceAnnotationBoolean = beanClass.isAnnotationPresent(WebService.class);
        boolean webserviceUrlAnnotationBoolean = beanClass.isAnnotationPresent(WebserviceUrl.class);

        if(webServiceAnnotationBoolean && webserviceUrlAnnotationBoolean){
            //构建切入点
            EndpointImpl endpoint=new EndpointImpl(springBus, bean);
            WebserviceUrl webserviceUrl = beanClass.getAnnotation(WebserviceUrl.class);
            //获取注释的值
            String webserviceUrlStr = webserviceUrl.value();
            endpoint.publish(webserviceUrlStr);
            //动态注册切入点
            String generateBeanName = generateBeanName(webserviceUrlStr, "endpoint");
            SpringBeanUtil.registeredBean(generateBeanName, endpoint);
        }
        return bean;
    }

    public String generateBeanName(String url,String beanName){
        url = url.replace("/","");
        return String.format("%s-%s",url,beanName);
    }
}
