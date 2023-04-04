package com.zcb.controller;

import com.zcb.config.SpringConfig;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Test {
    @org.junit.Test
        public void test() throws IOException {
            AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        DriverManagerDataSource dataSource = app.getBean("dataSource", DriverManagerDataSource.class);
        System.out.println(dataSource.getUsername());
        //这点其实有个问题就是配置中的SqlSessionFactory类型是SqlSessionFactory,但是实际得到的SqlSessionFactory类型是DefaultSqlSessionFactory
        DefaultSqlSessionFactory sqlSessionFactory = app.getBean("sqlSessionFactory", DefaultSqlSessionFactory.class);
        System.out.println(sqlSessionFactory);

    }
}
