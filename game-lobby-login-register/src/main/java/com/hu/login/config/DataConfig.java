package com.hu.login.config;

import com.hu.login.config.info.JdbcInfo;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author hu
 * @date 2021/12/3
 */
@Configuration
@ComponentScan(basePackages = "com.hu.login")
@MapperScan("com.hu.login.dao")
public class DataConfig {

    @Resource
    private JdbcInfo jdbcInfo;

    @Bean
    public DataSource getDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(jdbcInfo.getUrl());
        hikariDataSource.setDriverClassName(jdbcInfo.getDriver());
        hikariDataSource.setUsername(jdbcInfo.getUsername());
        hikariDataSource.setPassword(jdbcInfo.getPassword());
        hikariDataSource.setValidationTimeout(jdbcInfo.getValidationTimeout());
        hikariDataSource.setConnectionTimeout(jdbcInfo.getConnectionTimeout());
        hikariDataSource.setIdleTimeout(jdbcInfo.getIdleTimeout());
        hikariDataSource.setMaxLifetime(jdbcInfo.getMaxLifetime());
        hikariDataSource.setMaximumPoolSize(jdbcInfo.getMaximumPoolSize());
        hikariDataSource.setReadOnly(jdbcInfo.getReadOnly());
        hikariDataSource.setConnectionTestQuery(jdbcInfo.getConnectionTestQuery());
        return hikariDataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(jdbcInfo.getTypeAliasesPackage());
        return sqlSessionFactoryBean;
    }
}
