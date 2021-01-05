package com.huangfu.webservicetest.annotation;

import java.lang.annotation.*;

/**
 * 指定webservice url后缀
 *
 * @author huangfu
 * @date 2021年1月5日08:20:32
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebserviceUrl {
    String value();
}
