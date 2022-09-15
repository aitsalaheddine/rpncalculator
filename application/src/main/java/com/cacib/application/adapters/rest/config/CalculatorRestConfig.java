package com.cacib.application.adapters.rest.config;


import com.cacib.domain.adapter.CalculatorAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorRestConfig {

    @Bean
    public CalculatorAdapter CalculatorAdapter() {
        return new CalculatorAdapter();
    }
}
