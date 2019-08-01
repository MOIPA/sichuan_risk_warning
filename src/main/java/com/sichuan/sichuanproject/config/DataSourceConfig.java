package com.sichuan.sichuanproject.config;

import org.mapstruct.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * 数据源配置类
 *
 * @author tr
 * @create 2019-07-31 15:36
 **/
@Configuration
public class DataSourceConfig {
//    @Primary
    @Bean(name = "firstDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource firstDataSrouce(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="sendDataSource")
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource secondDatasource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源，将两个datasource存放在map里，后期使用时通过数据源名提取
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //配置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(firstDataSrouce());
        //配置多数据源
        HashMap<Object, Object> dsMap = new HashMap<>();
        dsMap.put("firstDataSource", firstDataSrouce());
        dsMap.put("secondDataSource", secondDatasource());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }
}
