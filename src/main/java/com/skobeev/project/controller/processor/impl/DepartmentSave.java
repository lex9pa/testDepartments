package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.exception.ValidationException;
import com.skobeev.project.model.Department;
import com.skobeev.project.service.DepartmentService;
import com.skobeev.project.service.impl.DepartmentServiceImpl;
import com.skobeev.project.util.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.DEPARTMENT_LIST;

public class DepartmentSave implements Processor {

    private Transformer transformer = new Transformer();
    private DepartmentService departmentService = new DepartmentServiceImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, CustomException {
        Department department = transformer.saveDepartment(req);
        try {
            departmentService.saveDepartment(department);
            res.sendRedirect(DEPARTMENT_LIST);
        } catch (ValidationException e) {
            req.setAttribute("error", e.getErrorMap());
            req.setAttribute("department", department);
            req.getRequestDispatcher("/pages/departmentForm.jsp").forward(req, res);
        }
    }
}
