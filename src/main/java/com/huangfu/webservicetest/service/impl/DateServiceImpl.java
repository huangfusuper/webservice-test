package com.huangfu.webservicetest.service.impl;

import com.huangfu.webservicetest.annotation.WebserviceUrl;
import com.huangfu.webservicetest.service.DateService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author huangfu
 */
@Service
@WebserviceUrl("/date")
@WebService(name = "DateServiceImpl",targetNamespace = "http://service.webservicetest.huangfu.com",
        endpointInterface="com.huangfu.webservicetest.service.DateService")
public class DateServiceImpl implements DateService {
    @Override
    public String getThisDate(String dateFormat) {
        return DateTimeFormatter.ofPattern(dateFormat).format(LocalDateTime.now());
    }
}
