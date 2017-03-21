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
import java.util.List;

import static com.skobeev.project.constants.PagesConstants.DEPARTMENT_LIST_JSP;

public class DepartmentList implements Processor {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, CustomException {
        List<Department> department = departmentService.getDepartmentList();
        req.setAttribute("departmentList", department);
        req.getRequestDispatcher(DEPARTMENT_LIST_JSP).forward(req, res);
    }
}
