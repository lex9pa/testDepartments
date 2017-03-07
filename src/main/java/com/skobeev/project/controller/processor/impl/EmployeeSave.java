package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.dao.EmployeeDao;
import com.skobeev.project.dao.impl.EmployeeDaoImpl;
import com.skobeev.project.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.skobeev.project.constants.PagesConstants.EMPLOYEE_LIST;

public class EmployeeSave implements Processor {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Employee employee = new Employee();
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

        employeeDao.saveEmployee(employee);
        res.sendRedirect(EMPLOYEE_LIST);
    }
}
