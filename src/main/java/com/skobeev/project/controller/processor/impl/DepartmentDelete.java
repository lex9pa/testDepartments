package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;
import com.skobeev.project.service.DepartmentService;
import com.skobeev.project.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.DEPARTMENT_LIST;

public class DepartmentDelete implements Processor {

    private DepartmentService departmentService = new DepartmentServiceImpl();
    private Department department = new Department();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, CustomException {

        departmentService.delete(department, Long.parseLong(req.getParameter("id")));
        res.sendRedirect(DEPARTMENT_LIST);
    }
}
