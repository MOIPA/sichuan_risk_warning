package com.sichuan.sichuanproject.service;

import com.sichuan.sichuanproject.config.DsEnum;

import java.lang.annotation.*;

/**
 * @author: tr
 * @Date: 2019-08-01
 * @Description:  用于service切换数据库的ds注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.METHOD})
public @interface DS {
    DsEnum value() default DsEnum.FIRST_DS;
}
