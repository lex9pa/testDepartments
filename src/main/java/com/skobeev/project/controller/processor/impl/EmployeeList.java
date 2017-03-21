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
import java.util.List;

import static com.skobeev.project.constants.PagesConstants.EMPLOYEE_LIST_JSP;

public class EmployeeList implements Processor {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, CustomException {
        List<Employee> employee = employeeService.getEmployeeList();
        req.setAttribute("employeeList", employee);
        req.getRequestDispatcher(EMPLOYEE_LIST_JSP).forward(req, res);
    }
}
