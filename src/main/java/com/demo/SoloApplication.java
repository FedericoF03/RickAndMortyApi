package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SoloApplication {

    private static final Logger logger = LoggerFactory.getLogger(SoloApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SoloApplication.class, args);
        logger.info("App is now running");
    }

}
