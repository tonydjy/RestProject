package com.tv.dao;

import com.tv.model.User;

public interface UserDao {
    void save(User user);
    void update(User user);
    void delete(User user);
    boolean checkUser(String name, String password);
}
