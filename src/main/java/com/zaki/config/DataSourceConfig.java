package com.zaki.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zaki
 */
@Configuration
public class DataSourceConfig {
    private Class<? extends DataSource> dataSourceType = org.apache.tomcat.jdbc.pool.DataSource.class;

    @Bean(name = "springDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource writeDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "second.datasource")
    public DataSource readDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Primary
    @Bean(name="dynamicDataSource")
    @DependsOn({"springDataSource","secondDataSource"})
    public AbstractRoutingDataSource dynamicDataSource(@Qualifier("springDataSource") DataSource springDataSource,
                                                       @Qualifier("secondDataSource") DataSource secondDataSource) {
        MultiDataSource dataSourceRouter = new MultiDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("springDataSource", springDataSource);
        targetDataSources.put("secondDataSource", secondDataSource);
        dataSourceRouter.setDefaultTargetDataSource(springDataSource);
        dataSourceRouter.setTargetDataSources(targetDataSources);

        DataSourceContextHolder.addDataSourceIds("springDataSource");
        DataSourceContextHolder.addDataSourceIds("secondDataSource");
        return dataSourceRouter;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(AbstractRoutingDataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/**/*.xml"));

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().getTypeAliasRegistry().registerAliases("com.zaki.model");
        return sqlSessionFactoryBean.getObject();
    }
}
