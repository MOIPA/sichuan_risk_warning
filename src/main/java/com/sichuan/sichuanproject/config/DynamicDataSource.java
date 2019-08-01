package com.sichuan.sichuanproject.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @author: tr
 * @Date: 2019-08-01
 * @Description:数据源路由器，动态数据源设置，负责提取线程中的当前数据库,这是关键，实现动态选择
 * 查看了AbstractRoutingDataSource的源码，发现本质其也是维护一个map，通过key（Object）来选择datasource
 * 所以通过aop注解事先修改key内容，spring选择数据源时过来用key抽取对象
 * 如果传入的对象为null，即key为空，spring会自动选择hikaridatasource作为默认数据源
 * 可在22行断点查看框架代码执行
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey(){
        log.info("数据源为:{}",DataSourceContextHolder.getDB());
        String db = DataSourceContextHolder.getDB();
        return db;
    }
}
