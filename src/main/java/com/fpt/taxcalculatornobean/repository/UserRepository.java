package com.fpt.taxcalculatornobean.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.taxcalculatornobean.model.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserRepository {
    public List<User> getAllUsers() throws IOException {
        String filePath = "datastore/users.json";
        TypeReference<List<User>> typeReference = new TypeReference<>() {};

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), typeReference);
    }
}
