package com.github.treasurehunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class TreasureHuntRegistrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.github.treasurehunt.TreasureHuntRegistrationApplication.class, args);
    }
}
