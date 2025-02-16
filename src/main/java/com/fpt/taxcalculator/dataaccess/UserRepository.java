package com.fpt.taxcalculator.dataaccess;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fpt.taxcalculator.model.User;
import com.fpt.taxcalculator.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class UserRepository {
    private final JsonUtils jsonUtils;

public UserRepository(JsonUtils jsonUtils) {
        this.jsonUtils = jsonUtils;
    }

    public List<User> getAllUsers() throws IOException {
        String filePath = "datastore/users.json";  // specify the path to your JSON file
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        return jsonUtils.parseFromJson(filePath, typeRef);
    }
}
