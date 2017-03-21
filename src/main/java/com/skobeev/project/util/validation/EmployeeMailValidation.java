package com.skobeev.project.util.validation;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Employee;
import com.skobeev.project.service.EmployeeService;
import com.skobeev.project.service.impl.EmployeeServiceImpl;
import net.sf.oval.constraint.CheckWithCheck;

public class EmployeeMailValidation implements CheckWithCheck.SimpleCheck {

    public boolean isSatisfied(Object validatedObject, Object value) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = null;
        if (validatedObject instanceof Employee) {
            try {
                employee = employeeService.getEmployeeByMail(value.toString());
                if(((Employee) validatedObject).getId()!=null) {
                    if (((Employee) validatedObject).getId().equals(employee.getId())) {
                        return true;
                    }
                }
            } catch (CustomException ignored) {
            }
        }
        return (employee != null ? employee.getId() : null) == null;
    }
}
