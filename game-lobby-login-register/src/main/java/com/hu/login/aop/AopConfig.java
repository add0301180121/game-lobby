package com.hu.login.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hu
 * @date 2021/12/4
 * @EnableAspectJAutoProxy 注解开启Spring对AspectJ的支持
 */
@Configuration
@ComponentScan(basePackages = {"com.hu.login"})
@EnableAspectJAutoProxy
public class AopConfig {
}
