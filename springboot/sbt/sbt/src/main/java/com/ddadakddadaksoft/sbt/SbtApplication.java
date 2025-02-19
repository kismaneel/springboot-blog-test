package com.ddadakddadaksoft.sbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SbtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbtApplication.class, args);
    }

}
