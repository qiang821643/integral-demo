package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 *
 */
@SpringBootApplication(scanBasePackages={"com.*"})
@MapperScan(basePackages="com.mapper")
//@EnableEurekaClient

public class IntegralApplication {
    public static void main( String[] args ){
       SpringApplication.run(IntegralApplication.class, args);
    }
}
