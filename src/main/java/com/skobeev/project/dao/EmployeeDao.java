package com.skobeev.project.dao;

import com.skobeev.project.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployeeList();

    void saveEmployee(Employee employee);

    void deleteEmployee(Long employeeId);
}
