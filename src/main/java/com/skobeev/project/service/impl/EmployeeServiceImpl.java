package com.skobeev.project.service.impl;

import com.skobeev.project.dao.CommonDelete;
import com.skobeev.project.dao.EmployeeDao;
import com.skobeev.project.dao.impl.CommonDeleteImpl;
import com.skobeev.project.dao.impl.EmployeeDaoImpl;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.exception.ValidationException;
import com.skobeev.project.model.Employee;
import com.skobeev.project.service.EmployeeService;
import com.skobeev.project.util.validation.ValidationModel;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {

    private CommonDelete commonDelete = new CommonDeleteImpl();
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private ValidationModel validator = new ValidationModel();

    public List<Employee> getEmployeeList() throws CustomException {
        return employeeDao.getEmployeeList();
    }

    public void delete(Object ob, Long id) throws CustomException {
        commonDelete.delete(ob, id);
    }

    public void saveEmployee(Employee employee) throws CustomException, ValidationException {
        Map<String, List<String>> errorMap = validator.validateObjects(employee);
        if (errorMap.isEmpty()) {
            employeeDao.saveEmployee(employee);
        } else throw new ValidationException(errorMap);
    }

    public Employee getEmployeeById(Long id) throws CustomException {
        return employeeDao.getEmployeeById(id);
    }

    public Employee getEmployeeByMail(String employeeMail) throws CustomException {
        return employeeDao.getEmployeeByMail(employeeMail);
    }
}
