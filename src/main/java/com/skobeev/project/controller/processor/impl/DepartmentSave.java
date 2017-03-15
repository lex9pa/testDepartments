package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.util.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.project.constants.PagesConstants.DEPARTMENT_LIST;

public class DepartmentSave implements Processor {

    private Transformer transformer = new Transformer();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, CustomException {
        transformer.saveDepartment(req);
        res.sendRedirect(DEPARTMENT_LIST);
    }
}
