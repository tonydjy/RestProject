package com.tv.service;

import com.tv.model.User;

public interface UserService {

    void save(User user);
    void update(User user);
    void delete(User user);
    boolean checkUser(String name, String password);
}