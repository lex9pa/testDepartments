package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.dao.DepartmentDao;
import com.skobeev.project.dao.impl.DepartmentDaoImpl;
import com.skobeev.project.model.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.skobeev.project.constants.PagesConstants.DEPARTMENT_LIST_JSP;

public class DepartmentList implements Processor {
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Department> department = departmentDao.getDepartmentList();
        req.setAttribute("departmentList", department);
        req.getRequestDispatcher(DEPARTMENT_LIST_JSP).forward(req, res);
    }
}
