package com.zj;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.zj.mapper")
@EnableDubbo
@EnableTransactionManagement
public class MimiserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MimiserviceApplication.class, args);
    }

}
