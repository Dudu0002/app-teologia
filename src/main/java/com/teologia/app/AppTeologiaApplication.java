package com.teologia.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"app_teologia", "com.teologia.app"})
@EnableJpaRepositories(basePackages = "com.teologia.app.repository")
@EntityScan(basePackages = "com.teologia.app.model")
public class AppTeologiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppTeologiaApplication.class, args);
    }
}