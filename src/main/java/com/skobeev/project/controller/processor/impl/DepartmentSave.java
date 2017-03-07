package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.dao.DepartmentDao;
import com.skobeev.project.dao.impl.DepartmentDaoImpl;
import com.skobeev.project.model.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.DEPARTMENT_LIST;

public class DepartmentSave implements Processor{
    private DepartmentDao departmentDao=new DepartmentDaoImpl();
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Department department=new Department();
        if (!req.getParameter("id").equals("")) {
            department.setId(Long.parseLong(req.getParameter("id")));
        }
        department.setDepartmentName(req.getParameter("name"));
        departmentDao.saveDepartment(department);
        res.sendRedirect(DEPARTMENT_LIST);
    }
}
