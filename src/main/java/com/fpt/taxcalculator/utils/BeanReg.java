package com.fpt.taxcalculator.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanReg {
    @Bean("standardRate")
    public double getStandardRate() {
        return 0.12;
    }
}
