package com.hu.login.config.info;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author hu
 * @date 2021/12/3
 */
@Data
@ToString
@Component
@PropertySource("classpath:mysql.properties")
public class JdbcInfo {
    @Value("${mysql.driver}")
    private String driver;

    @Value("${mysql.url}")
    private String url;

    @Value("${mysql.username}")
    private String username;

    @Value("${mysql.password}")
    private String password;

    @Value("${dataSource.validationTimeout}")
    private Long validationTimeout;

    @Value("${dataSource.connectionTimeout}")
    private Long connectionTimeout;

    @Value("${dataSource.idleTimeout}")
    private Long idleTimeout;

    @Value("${dataSource.maxLifetime}")
    private Long maxLifetime;

    @Value("${dataSource.maximumPoolSize}")
    private Integer maximumPoolSize;

    @Value("${dataSource.readOnly}")
    private Boolean readOnly;

    @Value("${dataSource.connectionTestQuery}")
    private String connectionTestQuery;

    @Value("${mybatis.type.alias.package=com.hu.entity}")
    private String typeAliasesPackage;
}
