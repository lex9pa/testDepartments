package com.skobeev.project.util;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;
import com.skobeev.project.model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Transformer {

    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");


    public Employee saveEmployee(HttpServletRequest req) throws CustomException {
        Employee employee = new Employee();
        if (!req.getParameter("id").equals("")) {
            employee.setId(Long.parseLong(req.getParameter("id")));
        }
        employee.setEmployeeName(req.getParameter("name"));
        employee.setEmployeeSurname(req.getParameter("surname"));
        employee.setEmployeeEmail(req.getParameter("email"));
        try {
            employee.setEmployeeBirthday(format.parse(req.getParameter("birthday")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setEmployeeSalary(Long.parseLong(req.getParameter("salary")));
        employee.setDepartmentId(Long.parseLong(req.getParameter("departmentId")));
        return employee;
    }

    public Department saveDepartment(HttpServletRequest req) throws CustomException {
        Department department = new Department();
        if (!req.getParameter("id").equals("")) {
            department.setId(Long.parseLong(req.getParameter("id")));
        }
        department.setDepartmentName(req.getParameter("name"));
        return department;
    }

}
