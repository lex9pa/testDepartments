package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;
import com.skobeev.project.model.Employee;
import com.skobeev.project.service.DepartmentService;
import com.skobeev.project.service.EmployeeService;
import com.skobeev.project.service.impl.DepartmentServiceImpl;
import com.skobeev.project.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.skobeev.project.constants.PagesConstants.EMPLOYEE_FORM_JSP;

public class EmployeeForm implements Processor {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();
    private Employee employee = new Employee();

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, CustomException {
        if (!req.getParameterMap().isEmpty()) {
            employee = employeeService.getEmployeeById(Long.parseLong(req.getParameter("id")));
        }
        List<Department> department = departmentService.getDepartmentList();
        req.setAttribute("departmentList", department);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher(EMPLOYEE_FORM_JSP).forward(req, res);
    }
}
