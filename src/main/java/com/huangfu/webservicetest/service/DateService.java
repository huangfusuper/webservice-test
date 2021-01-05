package com.huangfu.webservicetest.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author huangfu
 */
@WebService(name = "DateService", targetNamespace = "http://service.webservicetest.huangfu.com")
public interface DateService {

    /**
     * 获取当前时间
     * @param dateFormat 格式化
     * @return 默认格式化后的时间
     */
    @WebMethod
    String getThisDate(String dateFormat);
}
