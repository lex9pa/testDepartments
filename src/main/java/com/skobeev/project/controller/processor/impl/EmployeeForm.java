package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Employee;
import com.skobeev.project.util.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.EMPLOYEE_FORM_JSP;

public class EmployeeForm implements Processor {

    private Transformer transformer = new Transformer();

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, CustomException {
        Employee employee = transformer.getEmployeeById(req);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher(EMPLOYEE_FORM_JSP).forward(req, res);
    }
}
