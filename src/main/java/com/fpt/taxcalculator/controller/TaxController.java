package com.fpt.taxcalculator.controller;

import com.fpt.taxcalculator.service.TaxCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/tax")
public class TaxController {
    private final TaxCalculator taxCalculator;

    public TaxController(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @GetMapping("/{userId}")
    public double calculateTax(@PathVariable Long userId) throws IOException {
        return taxCalculator.calculate(userId);
    }
}
