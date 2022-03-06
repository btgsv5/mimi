package com.zj;

import com.zj.controller.ProductTypeController;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@SpringBootApplication
@EnableDubbo

public class MimiwebApplication extends ServletInitializer {

    public static void main(String[] args) {
          SpringApplication.run(MimiwebApplication.class, args);

    }


}
