package com.fpt.taxcalculator.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fpt.taxcalculator.model.Tax;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class TaxRepository {
    private final JsonUtils jsonUtils;

    public TaxRepository(JsonUtils jsonUtils) {
        this.jsonUtils = jsonUtils;
    }

    public List<Tax> getAll() throws IOException {
        return getAllTaxConfig();
    }

    public Tax findByLevel(String level) throws IOException {
        List<Tax> tax = getAllTaxConfig();
        Optional<Tax> foundUser = tax.stream().filter(taxConfig -> taxConfig.getLevel().equals(level)).findFirst();

        if (foundUser.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return foundUser.get();
    }

    private List<Tax> getAllTaxConfig() throws IOException {
        String filePath = "datastore/tax.json";  // specify the path to your JSON file
        TypeReference<List<Tax>> typeRef = new TypeReference<>() {};
        return jsonUtils.parseFromJson(filePath, typeRef);
    }
}
