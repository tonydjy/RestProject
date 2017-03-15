package com.tv.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.tv.dao.UserDao;
import com.tv.model.User;
import com.tv.service.UserService;

@Transactional//配置事务
public class UserServiceImpl implements UserService {

    //注入Dao层
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //增
    public void save(User user){
    	userDao.save(user);
    }
    //改
    public void update(User user){
    	userDao.update(user);
    }
    //删
    public void delete(User user){
    	userDao.delete(user);
    }
    //查
    public boolean checkUser(String name, String password){
    	return userDao.checkUser(name, password);
    }
    
}