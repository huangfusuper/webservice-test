package com.huangfu.webservicetest.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangfu
 */
@Configuration
public class WebSocketServerConfig {

    /**
     * 发布服务名称
     *
     * @return Servlet注册Bean
     */
    @Bean
    public ServletRegistrationBean<CXFServlet> servletServletRegistrationBean() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }


    @Bean
    public AutoWebServiceEndpoint autoWebServiceEndpoint(SpringBus springBus) {
        return new AutoWebServiceEndpoint(springBus);
    }
}
