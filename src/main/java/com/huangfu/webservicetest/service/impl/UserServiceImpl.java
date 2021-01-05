package com.huangfu.webservicetest.service.impl;

import com.huangfu.webservicetest.annotation.WebserviceUrl;
import com.huangfu.webservicetest.service.UserService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 模拟业务操作
 *
 * @author huangfu
 * @date 2021年1月5日08:19:24
 */
@Service
@WebserviceUrl("/user")
@WebService(name = "UserServiceImpl",targetNamespace = "http://service.webservicetest.huangfu.com",
        endpointInterface="com.huangfu.webservicetest.service.UserService")
public class UserServiceImpl implements UserService {
    @Override
    public String getThisDate() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}
