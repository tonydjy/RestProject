package com.tv.service;

import com.tv.model.Role;

public interface RoleService {
    void save(Role role);
    void update(Role role);
    void delete(Role role);
    Role getRole(String roleName);
}
