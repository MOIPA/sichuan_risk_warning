package com.sichuan.sichuanproject.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: tr
 * @Date: 2019-8-01
 * @Description:设置线程安全类，存放数据库源标识(String)，用于动态切换数据库源
 */
@Slf4j
@Component
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static final DsEnum DEFAULT_DS = DsEnum.FIRST_DS;
    public static void setDB(DsEnum db) {
        log.info("切换到{}数据源",db.getMessage());
        contextHolder.set(db.getDs());
    }

    public static String getDB() {
        return contextHolder.get();
    }

    public static void clearDB() {
        contextHolder.remove();
    }
}
