package com.lia.common.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.lia.common.spring", "com.lia.common.spring.mysql"})
public class CommonConfig {
}