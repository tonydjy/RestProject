package com.tv.service;

import com.tv.model.User;

public interface UserService {

    void save(User user);
    void update(User user);
    void delete(User user);
    User getUser(String name);
    boolean authUser(String name, String password);
    boolean checkUserExist(String name);
}