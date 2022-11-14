package com.hlm.ddd_hexagonal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class DddHexagonalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DddHexagonalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    byte[]b="12345".getBytes();
        System.out.println("BYTE: "+b);
        String ab="123456";
        ab=UUID.randomUUID().toString();

        UUID uuid = UUID.fromString(ab);
       // System.out.println("UUI: "+a);
        System.out.println("=======================");
        for (int i = 0; i < 5 ; i++) {
            String helper = "#";
            for (int j = 0; j <= i; j++) {
                System.out.print(helper);
            }
            System.out.println("");
        }
    }
}
