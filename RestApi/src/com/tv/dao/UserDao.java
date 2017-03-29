package com.tv.dao;

import com.tv.model.User;

public interface UserDao {
    void save(User user);
    void update(User user);
    void delete(User user);
    boolean authUser(String name, String password);
    boolean checkUserExist(String name);
}
