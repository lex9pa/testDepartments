package com.skobeev.project.service;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList() throws CustomException;

    void saveEmployee(Employee employee) throws CustomException;

    Employee getEmployeeById(Long id) throws CustomException;
}
