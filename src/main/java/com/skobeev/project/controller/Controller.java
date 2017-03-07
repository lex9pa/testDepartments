package com.skobeev.project.controller;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.controller.processor.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller extends HttpServlet {
    private static Map<String, Processor> PROCESSOR_MAP = new HashMap<String, Processor>() {{
        put("/", new Main());
        put("/department/list", new DepartmentList());
        put("/department/form", new DepartmentForm());
        put("/department/save", new DepartmentSave());
        put("/department/delete", new DepartmentDelete());
        put("/employee/list", new EmployeeList());
        put("/employee/form", new EmployeeForm());
        put("/employee/save", new EmployeeSave());
        put("/employee/delete", new EmployeeDelete());
    }};

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String url = req.getRequestURI();
        Processor processor = PROCESSOR_MAP.get(url);
        if (processor != null) {
            processor.service(req, res);
        }
    }

}
