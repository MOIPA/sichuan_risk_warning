package com.sichuan.sichuanproject.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @author: tr
 * @Date: 2019-08-01
 * @Description:数据源路由器，动态数据源设置，负责提取线程中的当前数据库
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("数据源为:{}",DataSourceContextHolder.getDB());
        String db = DataSourceContextHolder.getDB();
        return db;
    }
}
