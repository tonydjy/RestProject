package com.tv.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.tv.dao.RoleDao;

import com.tv.model.Role;
import com.tv.service.RoleService;
@Transactional//≈‰÷√ ¬ŒÒ

public class RoleServiceImpl implements RoleService {
	private RoleDao roledao;
	
    public void setRoleDao(RoleDao roledao) {
        this.roledao = roledao;
    }

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		roledao.save(role);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roledao.update(role);
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		roledao.delete(role);
	}

	@Override
	public Role getRole(String roleName) {
		// TODO Auto-generated method stub
		return roledao.getRole(roleName);
	}

}
