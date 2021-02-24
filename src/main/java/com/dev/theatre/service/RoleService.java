package com.dev.theatre.service;

import com.dev.theatre.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
