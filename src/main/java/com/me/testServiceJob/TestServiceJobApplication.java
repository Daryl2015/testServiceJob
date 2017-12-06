package com.me.testServiceJob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 启动
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class TestServiceJobApplication extends SpringBootServletInitializer {

    public static void main( String[] args )
    {
        SpringApplication.run(TestServiceJobApplication.class, args);
    }
}
