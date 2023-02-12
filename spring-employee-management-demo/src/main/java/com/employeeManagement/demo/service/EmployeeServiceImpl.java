package com.employeeManagement.demo.service;

import com.employeeManagement.demo.entity.Employee;
import com.employeeManagement.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee getEmployeeById(int id) {


        Optional<Employee> result = employeeRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new RuntimeException("Book does not exists for Id : "+id);
        }
    }

    @Override
    public int getCount() {
        return (int)employeeRepository.count();
    }

    @Override
    public List<Employee> getEmployeeByFirstName(String name) {
        return employeeRepository.getEmployeeByFirstName(name);
    }

    @Override
    public List<Employee> getAllEmployeesSorted(String order) {
        if(order.toUpperCase().equals("ASC"))
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"firstName"));
        else return employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"firstName"));
    }


}