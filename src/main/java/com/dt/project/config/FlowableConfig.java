package com.dt.project.config;


import org.flowable.common.engine.impl.persistence.StrongUuidGenerator;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName ActivitiConfig
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/5 12:42
 *
 * 配置flowable
 **/
@Configuration
public class FlowableConfig {


    @Autowired
    private DataSource dataSource;


    /**
     * 配置springboot 事务
     *
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 配置uuid bean
     *
     * @return
     */
    @Bean
    public StrongUuidGenerator strongUuidGenerator() {
        return new StrongUuidGenerator();
    }

    /**
     * 配置bean
     *
     * @return
     */
    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration() {
        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setDataSource(dataSource);
        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        springProcessEngineConfiguration.setTransactionManager(dataSourceTransactionManager(dataSource));
        springProcessEngineConfiguration.setAsyncExecutorActivate(false);
        springProcessEngineConfiguration.setDatabaseType("mysql");
        springProcessEngineConfiguration.setIdGenerator(strongUuidGenerator());
        return springProcessEngineConfiguration;


    }
}
