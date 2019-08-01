package com.sichuan.sichuanproject.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
public class MyBatisConfig {
    /**
     * 第一个数据库 SqlSessionFactory && SqlSessionTemplate 创建
     */
//    @Configuration
//    @MapperScan(basePackages = {"com.sichuan.sichuanproject.mapper.primary"},
//            sqlSessionFactoryRef = "sqlSessionFactoryOne",
//            sqlSessionTemplateRef = "sqlSessionTemplateOne")
//    public static  class DBOne{
//        @Resource
//        DataSource dbOneDataSource;
//        @Bean
//        public SqlSessionFactory sqlSessionFactoryOne() throws Exception {
//            log.info("sqlSessionFactoryOne 创建成功。");
//            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//            factoryBean.setDataSource(dbOneDataSource);
////            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/one/*.xml"));
//            return factoryBean.getObject();
//        }
//        @Bean
//        public SqlSessionTemplate sqlSessionTemplateOne() throws Exception {
//            SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryOne()); // 使用上面配置的Factory
//            return template;
//        }
//    }
//    /**
//     * 第二个数据库 SqlSessionFactory && SqlSessionTemplate 创建
//     */
//    @Configuration
//    @MapperScan(basePackages = {"com.sichuan.sichuanproject.mapper.second"},
//            sqlSessionFactoryRef = "sqlSessionFactoryTwo",
//            sqlSessionTemplateRef ="sqlSessionTemplateTwo" )
//    public static class DBTwo{
//        @Resource
//        DataSource dbTwoDataSource;
//        @Bean
//        public SqlSessionFactory sqlSessionFactoryTwo() throws Exception {
//            log.info("sqlSessionFactoryTwo 创建成功。");
//            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//            factoryBean.setDataSource(dbTwoDataSource);
//            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/two/*.xml"));
//            return factoryBean.getObject();
//        }
//        @Bean
//        public SqlSessionTemplate sqlSessionTemplateTwo() throws Exception {
//            SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryTwo()); // 使用上面配置的Factory
//            return template;
//        }
//    }
}
