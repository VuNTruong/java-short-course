package com.fpt.taxcalculator.controller;

import com.fpt.taxcalculator.model.Tax;
import com.fpt.taxcalculator.service.TaxCalculator;
import com.fpt.taxcalculator.service.TaxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/tax")
public class TaxController {
    private final TaxService taxService;
    private final TaxCalculator taxCalculator;

    public TaxController(TaxService taxService,
                         TaxCalculator taxCalculator) {
        this.taxService = taxService;
        this.taxCalculator = taxCalculator;
    }

    @GetMapping
    public List<Tax> getAllTaxConfigs() throws IOException {
        return taxService.getAllTaxConfigs();
    }

    @GetMapping("/calculate/user/{userId}")
    public double calculateTax(@PathVariable Long userId) throws IOException {
        return taxCalculator.calculate(userId);
    }
}
