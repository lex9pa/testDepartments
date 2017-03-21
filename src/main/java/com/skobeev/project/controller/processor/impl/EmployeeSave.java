package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.exception.ValidationException;
import com.skobeev.project.model.Department;
import com.skobeev.project.model.Employee;
import com.skobeev.project.service.DepartmentService;
import com.skobeev.project.service.EmployeeService;
import com.skobeev.project.service.impl.DepartmentServiceImpl;
import com.skobeev.project.service.impl.EmployeeServiceImpl;
import com.skobeev.project.util.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.skobeev.project.constants.PagesConstants.EMPLOYEE_LIST;

public class EmployeeSave implements Processor {

    private Transformer transformer = new Transformer();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, CustomException {
        Employee employee = transformer.saveEmployee(req);
        try {
            employeeService.saveEmployee(employee);
            res.sendRedirect(EMPLOYEE_LIST);
        } catch (ValidationException e) {
            List<Department> department = departmentService.getDepartmentList();
            req.setAttribute("departmentList", department);
            req.setAttribute("error", e.getErrorMap());
            req.setAttribute("employee", employee);
            req.getRequestDispatcher("/pages/employeeForm.jsp").forward(req, res);
        }
    }
}
