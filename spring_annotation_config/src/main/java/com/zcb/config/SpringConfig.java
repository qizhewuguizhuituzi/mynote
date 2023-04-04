package com.zcb.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ComponentScan("com.zcb")
@Configuration
//开启aop注解功能
@EnableAspectJAutoProxy
//该注解是扫描dao下的接口生成代理不需要自己去写实现类当然也可以写类去配置
@MapperScan(basePackages = "com.zcb.dao")
public class SpringConfig {
    /*配置Spring数据源*/
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //配置url的时候要注意到后面的&符号连接与xml中&nmp;的不同
        dataSource.setUrl("jdbc:mysql://localhost:3306/springtest?useSSL=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    /*配置sqlSessionFactory*/
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Autowired DriverManagerDataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/zcb/dao/*.xml"));
        factoryBean.setTypeAliasesPackage("com.zcb.pojo");
        return factoryBean;
    }

    /*配置sqlSession*/
    @Bean
    public SqlSessionTemplate sqlSession(@Autowired SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean.getObject());
        return sqlSessionTemplate;
    }

    /*配置事务管理器,无论声明式事务还是编程式事务都需要配置事务管理器*/
    @Bean
    public DataSourceTransactionManager transactionManager(@Autowired DriverManagerDataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
