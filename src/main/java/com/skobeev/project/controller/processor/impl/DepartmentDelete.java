package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.dao.DepartmentDao;
import com.skobeev.project.dao.impl.DepartmentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.*;

public class DepartmentDelete implements Processor {
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        departmentDao.deleteDepartment(Long.parseLong(req.getParameter("id")));
        res.sendRedirect(DEPARTMENT_LIST);
    }
}
