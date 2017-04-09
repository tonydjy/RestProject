package com.tv.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.tv.dao.UserDao;
import com.tv.model.Role;
import com.tv.model.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

    /**
     * ���淽��
     */
    public void save(User user){
        getHibernateTemplate().save(user);
    }
    /**
     * ���·���
     */
    public void update(User user){
        getHibernateTemplate().update(user);
    }
    /**
     * ɾ������
     */
    public void delete(User user){
        getHibernateTemplate().delete(user);
    }
    /**
     * ���ݹ�Ʊ���뷽������ѯ��Ʊ��Ϣ
     * stockName �� stockCode ��������UNIQUE Լ�������Ա�ʶÿ�� ����
     */
    public User getUser(String name){
        // from �� ʵ������
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
        // from �� ʵ������
    	User user = null;
        List list = getHibernateTemplate().find(
                      "from User where name=? and password=?",name,password
                );
   
        return !(list.isEmpty());
    }
    
    public boolean checkUserExist(String name){
        // from �� ʵ������
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