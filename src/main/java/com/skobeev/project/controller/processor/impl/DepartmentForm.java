package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.dao.DepartmentDao;
import com.skobeev.project.dao.impl.DepartmentDaoImpl;
import com.skobeev.project.model.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.DEPARTMENT_FORM_JSP;

public class DepartmentForm implements Processor {
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Department department = new Department();
        if (!req.getParameterMap().isEmpty()) {
            department = departmentDao.getDepartmentListById(Long.parseLong(req.getParameter("id")));
        }
        req.setAttribute("department", department);
        req.getRequestDispatcher(DEPARTMENT_FORM_JSP).forward(req, res);

    }
}
