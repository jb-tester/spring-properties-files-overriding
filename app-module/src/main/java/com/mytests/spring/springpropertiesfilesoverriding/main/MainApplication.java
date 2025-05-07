package com.mytests.spring.springpropertiesfilesoverriding.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    // Defined in this module main application.properties file. Should be available - ok
    @Value("${my.app.props.main:not set}") String p1;
    // Defined in this module test application.properties file. Should NOT be available!!!
    @Value("${my.app.props.test:not set}") String p2;
    // Defined in lib module application.properties file. Should NOT be available!!!
    @Value("${my.lib.props.main:not set}") String p3;
    // Defined in lib module application.yaml file. Should NOT be available - ok
    @Value("${my.lib.yaml.test:not set}") String p4;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner( ) {
        return args -> {
            System.out.println("--------------------------------------");

            System.out.println("p1: " + p1);
            System.out.println("p2: " + p2);
            System.out.println("p3: " + p3);
            System.out.println("p4: " + p4);

            System.out.println("--------------------------------------");
        };
    }
}
