package com.tv.dao;
import com.tv.model.Role;

public interface RoleDao {
    void save(Role role);
    void update(Role role);
    void delete(Role role);
    Role getRole(String roleName);
}
