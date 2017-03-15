package com.tv.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.tv.dao.UserDao;
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
    public boolean checkUser(String name, String password){
        // from �� ʵ������
    	User user = null;
        List list = getHibernateTemplate().find(
                      "from User where name=? and password=?",name,password
                );
   
        return !(list.isEmpty());
    }

}