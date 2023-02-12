package com.employeeManagement.demo.service;

import com.employeeManagement.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee saveEmployee(Employee employee);
    public void deleteEmployeeById(int id);
    public Employee getEmployeeById(int id);

    public int getCount();
    List<Employee> getEmployeeByFirstName(String name);

    public List<Employee> getAllEmployeesSorted(String order);
}