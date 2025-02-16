package com.fpt.taxcalculator.dataaccess;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fpt.taxcalculator.model.User;
import com.fpt.taxcalculator.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final JsonUtils jsonUtils;

public UserRepository(JsonUtils jsonUtils) {
        this.jsonUtils = jsonUtils;
    }

    public List<User> findAll() throws IOException {
        return getAllUsers();
    }

    public User findByUserId(Long userId) throws IOException {
        String filePath = "datastore/users.json";  // specify the path to your JSON file
        TypeReference<List<User>> typeRef = new TypeReference<>() {};

        List<User> users = jsonUtils.parseFromJson(filePath, typeRef);
        Optional<User> foundUser = users.stream().filter(user -> user.getId().equals(userId)).findFirst();

        if (foundUser.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return foundUser.get();
    }

    public List<User> getAllUsers() throws IOException {
        String filePath = "datastore/users.json";  // specify the path to your JSON file
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        return jsonUtils.parseFromJson(filePath, typeRef);
    }
}
