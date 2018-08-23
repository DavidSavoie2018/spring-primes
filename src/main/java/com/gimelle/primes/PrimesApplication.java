package com.gimelle.primes;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = { "com.gimelle.primes" })
public class PrimesApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PrimesApplication.class).run(args);
    }

}
