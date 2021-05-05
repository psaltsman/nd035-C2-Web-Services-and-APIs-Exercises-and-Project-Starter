package com.udacity.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Creates a Spring Boot Application to run the Pricing Service.
 */
@SpringBootApplication
@EnableEurekaClient
public class PricingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApplication.class, args);
    }

    @Bean
    @Qualifier("restTemplate")
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {

        return builder.build();
    }
}
