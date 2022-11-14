package com.hlm.ddd_hexagonal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DddHexagonalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DddHexagonalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {}
}
