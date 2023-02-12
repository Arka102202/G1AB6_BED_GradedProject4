package com.employeeManagement.demo.service;

import com.employeeManagement.demo.entity.Role;
import com.employeeManagement.demo.exception.DuplicateRoleException;
import com.employeeManagement.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepo roleRepo;
    @Override
    public Role saveRole(Role role) {
        if(roleRepo.findByName(role.getName()) != null) throw new DuplicateRoleException("Role already exist");
        return roleRepo.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepo.findByName(name);
    }
}
