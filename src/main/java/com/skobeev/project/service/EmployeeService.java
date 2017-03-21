package com.skobeev.project.service;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.exception.ValidationException;
import com.skobeev.project.model.Employee;

import java.util.List;

public interface EmployeeService {

    void delete(Object ob, Long id) throws CustomException;

    List<Employee> getEmployeeList() throws CustomException;

    void saveEmployee(Employee employee) throws CustomException, ValidationException;

    Employee getEmployeeById(Long id) throws CustomException;

    Employee getEmployeeByMail(String employeeMail) throws CustomException;
}
