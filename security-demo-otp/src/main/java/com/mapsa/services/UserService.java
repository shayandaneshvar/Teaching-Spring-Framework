package com.mapsa.services;

import com.mapsa.model.User;

import java.util.Collection;

public interface UserService {
    void saveUser(User user);

    Collection<User> getAllUsers();

    void deleteById(Long id);
}
