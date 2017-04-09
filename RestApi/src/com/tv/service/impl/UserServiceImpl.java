package com.tv.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.tv.dao.UserDao;
import com.tv.model.User;
import com.tv.service.UserService;

@Transactional//��������
public class UserServiceImpl implements UserService {

    //ע��Dao��
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //��
    public void save(User user){
    	userDao.save(user);
    }
    //��
    public void update(User user){
    	userDao.update(user);
    }
    //ɾ
    public void delete(User user){
    	userDao.delete(user);
    }

    public boolean checkUserExist(String name){
    	return userDao.checkUserExist(name);
    }
    
    public boolean authUser(String name, String password){
    	return userDao.authUser(name, password);
    }

	public User getUser(String name) {
		// TODO Auto-generated method stub
		return userDao.getUser(name);
	}

    
}