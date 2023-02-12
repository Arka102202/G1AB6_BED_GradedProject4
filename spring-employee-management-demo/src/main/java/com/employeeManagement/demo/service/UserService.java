package com.employeeManagement.demo.service;

import com.employeeManagement.demo.entity.Role;
import com.employeeManagement.demo.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user) ;
    User findUserByName(String username);
    List<User> getAll();
    User updateUser(Role role, int id);
}
