package com.example.eurekaclient.configs;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * 数据库连接配置。
 */
@Configuration
@ConfigurationProperties(prefix = "db.product")
@MapperScan(sqlSessionFactoryRef = DBConfig.SQL_SESSION_FACTORY_NAME,
        basePackages = {"com.example.eurakaclient.dao.mapper.product"})
public class DBConfig {
    public final static String SQL_SESSION_FACTORY_NAME = "ProductSessionFactory";
    public final static String TRANSACTION_MANAGER_NAME = "ProductTranManager";
    public final static String DATA_SOURCE_NAME = "ProductDataSource";

    private String url;
    private String username;
    private String password;

    /**
     * 连接配置。
     *
     * @return
     */
    @Bean(name = DATA_SOURCE_NAME)
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setConnectionErrorRetryAttempts(0);
        dataSource.setMaxActive(10);
        dataSource.setTestWhileIdle(true);
        dataSource.setDefaultAutoCommit(true);
        dataSource.setMaxWait(60000);
        return dataSource;
    }

    /**
     * 事务管理器。
     *
     * @return
     */
    @Bean(name = TRANSACTION_MANAGER_NAME)
    public DataSourceTransactionManager transactionManager(@Qualifier(DATA_SOURCE_NAME) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = SQL_SESSION_FACTORY_NAME)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(DATA_SOURCE_NAME) DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(true);
        sessionFactory.setConfiguration(configuration);
        return sessionFactory.getObject();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
