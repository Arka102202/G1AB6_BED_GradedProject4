package com.employeeManagement.demo.controller;

import com.employeeManagement.demo.entity.Employee;
import com.employeeManagement.demo.model.ErrorResponse;
import com.employeeManagement.demo.responseHandler.HttpStatusCode;
import com.employeeManagement.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v-0-1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/{name}")
    public ResponseEntity<List<Employee>> getEmployeeByFirstName(@PathVariable("name") String name) {
        List<Employee> employees = employeeService.getEmployeeByFirstName(name);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/sort")
    public ResponseEntity<List<Employee>> getEmployeeSorted(@RequestParam(value = "order") String order) {
        List<Employee> employees = employeeService.getAllEmployeesSorted(order);
        return ResponseEntity.ok(employees);
    }
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        employee =  employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.saveEmployee(employee));
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        employeeService.deleteEmployeeById(id);
        return "deleted employee with id: " +id;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> genericExceptionHandler(Exception exc) throws ParseException {
        ErrorResponse response = new ErrorResponse(400, exc.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, new HttpStatusCode(400).getHttpStatus());
    }
}
















