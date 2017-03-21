package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Employee;
import com.skobeev.project.service.EmployeeService;
import com.skobeev.project.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.EMPLOYEE_LIST;

public class EmployeeDelete implements Processor {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private Employee employee = new Employee();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, CustomException {

        employeeService.delete(employee, Long.parseLong(req.getParameter("id")));
        res.sendRedirect(EMPLOYEE_LIST);
    }
}
