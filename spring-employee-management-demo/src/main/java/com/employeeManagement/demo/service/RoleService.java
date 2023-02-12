package com.employeeManagement.demo.service;

import com.employeeManagement.demo.entity.Role;

public interface RoleService {
    Role saveRole(Role role);

    Role findByName(String name);
}
