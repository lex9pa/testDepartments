package com.skobeev.project.dao;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployeeList() throws CustomException;

    void saveEmployee(Employee employee) throws CustomException;

    Employee getEmployeeById(Long id) throws CustomException;

    Employee getEmployeeByMail(String employeeEmail) throws CustomException;
}
