package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.dao.EmployeeDao;
import com.skobeev.project.dao.impl.EmployeeDaoImpl;
import com.skobeev.project.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.skobeev.project.constants.PagesConstants.EMPLOYEE_LIST_JSP;

public class EmployeeList implements Processor {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Employee> employee = employeeDao.getEmployeeList();
        req.setAttribute("employeeList", employee);
        req.getRequestDispatcher(EMPLOYEE_LIST_JSP).forward(req, res);
    }
}
