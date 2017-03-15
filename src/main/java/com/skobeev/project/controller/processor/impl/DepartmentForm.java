package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;
import com.skobeev.project.service.DepartmentService;
import com.skobeev.project.service.impl.DepartmentServiceImpl;
import com.skobeev.project.util.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.DEPARTMENT_FORM_JSP;

public class DepartmentForm implements Processor {
    private Transformer transformer = new Transformer();

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, CustomException {
        Department department = transformer.getDepListDyId(req);
        req.setAttribute("department", department);
        req.getRequestDispatcher(DEPARTMENT_FORM_JSP).forward(req, res);

    }
}
