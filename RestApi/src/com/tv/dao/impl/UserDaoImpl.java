package com.tv.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.tv.dao.UserDao;
import com.tv.model.Role;
import com.tv.model.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

    /**
     * 保存方法
     */
    public void save(User user){
        getHibernateTemplate().save(user);
    }
    /**
     * 更新方法
     */
    public void update(User user){
        getHibernateTemplate().update(user);
    }
    /**
     * 删除方法
     */
    public void delete(User user){
        getHibernateTemplate().delete(user);
    }
    /**
     * 根据股票代码方法，查询股票信息
     * stockName 和 stockCode 都设置了UNIQUE 约束，可以标识每行 数据
     */
    public User getUser(String name){
        // from 跟 实体类名
    	User user = null;
        List list = getHibernateTemplate().find(
                      "from User where name=?",name
                );
        if(list.isEmpty()){
        	return user;
        }
        else
        	return (User)list.get(0);
    }
    
    public boolean authUser(String name, String password){
        // from 跟 实体类名
    	User user = null;
        List list = getHibernateTemplate().find(
                      "from User where name=? and password=?",name,password
                );
   
        return !(list.isEmpty());
    }
    
    public boolean checkUserExist(String name){
        // from 跟 实体类名
    	User user = null;
        List list = getHibernateTemplate().find(
                      "from user where name=?", name
                );
   
        return !(list.isEmpty());
    }
	@Override
	public int deleteRoles(User user) {
    	String hql = "delete from user_role where userid= :userid";
        int result_size = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).setLong("userid", user.getUserid()).executeUpdate();
        return result_size;
		
	}

}