package com.fpt.taxcalculator.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaxRate {
    @Bean("standardRate")
    public double getStandardRate() {
        return 0.1;
    }

    @Bean("above30Rate")
    public double getAbove30Rate() {
        return 0.12;
    }

    @Bean("above50Rate")
    public double getAbove50Rate() {
        return 0.2;
    }
}
