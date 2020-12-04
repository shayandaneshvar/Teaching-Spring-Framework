package com.mapsa.thymeleaf.services;

import com.mapsa.thymeleaf.model.User;

import java.util.Collection;

public interface UserService {
    void saveUser(User user);

    Collection<User> getAllUsers();

    void deleteById(Long id);
}
