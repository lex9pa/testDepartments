package com.skobeev.project.service.impl;

import com.skobeev.project.dao.EmployeeDao;
import com.skobeev.project.dao.impl.EmployeeDaoImpl;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Employee;
import com.skobeev.project.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    public List<Employee> getEmployeeList() throws CustomException {
        return employeeDao.getEmployeeList();
    }

    public void saveEmployee(Employee employee) throws CustomException {
        employeeDao.saveEmployee(employee);
    }

    public Employee getEmployeeById(Long id) throws CustomException {
        return employeeDao.getEmployeeById(id);
    }
}
