package com.huangfu.webservicetest.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author huangfu
 * @date 2021年1月5日08:22:09
 */
@WebService(name = "UserService", targetNamespace = "http://service.webservicetest.huangfu.com")
public interface UserService {
    /**
     * 获取当前时间
     *
     * @return 默认格式化后的时间
     */
    @WebMethod
    String getThisDate();
}
