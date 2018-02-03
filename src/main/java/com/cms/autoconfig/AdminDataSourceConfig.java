package com.cms.autoconfig;

import com.cms.plugin.PagePlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * 统计库数据源
 */
@Configuration
@MapperScan(basePackages = "com.kuwo.dao",sqlSessionTemplateRef  = "adminSqlSessionTemplate")
public class AdminDataSourceConfig {

    @Bean(name = "adminDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource adminDataSource() {
        return DataSourceBuilder.create().build();
        
        
        //return new org.apache.tomcat.jdbc.pool.DataSource();
    }

    @Bean(name = "adminSqlSessionFactory")
    @Primary
    public SqlSessionFactory adminSqlSessionFactory(@Qualifier("adminDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        
        //分页插件
//        PageHelper pageHelper = new PageHelper();
        PagePlugin pagePlugin = new PagePlugin();
//        Properties props = new Properties();
//        props.setProperty("reasonable", "true");
//        props.setProperty("supportMethodsArguments", "true");
//        props.setProperty("returnPageInfo", "check");
//        props.setProperty("params", "count=countSql");
//        pageHelper.setProperties(props);
        //添加插件
        bean.setPlugins(new Interceptor[]{pagePlugin});
        // 结束
        bean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis/mybatis-config.xml"));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/system/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "adminTransactionManager")
    @Primary
    public DataSourceTransactionManager adminTransactionManager(@Qualifier("adminDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "adminSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate adminSqlSessionTemplate(@Qualifier("adminSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
