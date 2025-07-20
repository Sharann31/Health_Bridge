package com.advancedproject.service;

import com.advancedproject.model.User;

public interface UserService {
    void saveUser(User user);
    User getUserByUsername(String username);
}
