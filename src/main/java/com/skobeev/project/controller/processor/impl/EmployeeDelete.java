package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.dao.EmployeeDao;
import com.skobeev.project.dao.impl.EmployeeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.EMPLOYEE_LIST;

public class EmployeeDelete implements Processor {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        employeeDao.deleteEmployee(Long.parseLong(req.getParameter("id")));
        res.sendRedirect(EMPLOYEE_LIST);
    }
}
