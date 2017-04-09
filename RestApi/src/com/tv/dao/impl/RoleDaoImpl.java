package com.tv.dao.impl;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import com.tv.dao.RoleDao;
import com.tv.model.Role;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao{

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		   getHibernateTemplate().save(role);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(role);
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(role);
	}

	@Override
	public Role getRole(String roleName) {
		// TODO Auto-generated method stub
		Role role = null;
        List list = getHibernateTemplate().find(
                      "from Role where Name=?",roleName
                );
        if(list.isEmpty()){
        	return role;
        }
        else
        	return (Role)list.get(0);
	}

}
