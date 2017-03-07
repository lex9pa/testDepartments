package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.EMPLOYEE_FORM_JSP;

public class EmployeeForm implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect(EMPLOYEE_FORM_JSP);
    }
}
