package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.model.Tax;
import com.fpt.taxcalculator.repository.TaxRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class TaxService {
    private final TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public Tax findByLevel(String level) throws IOException {
        return taxRepository.findByLevel(level);
    }

    public List<Tax> getAllTaxConfigs() throws IOException {
        return taxRepository.getAll();
    }
}
