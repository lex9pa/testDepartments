package com.skobeev.project.util;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;
import com.skobeev.project.model.Employee;
import com.skobeev.project.service.DeleteService;
import com.skobeev.project.service.DepartmentService;
import com.skobeev.project.service.EmployeeService;
import com.skobeev.project.service.impl.DeleteServiceImpl;
import com.skobeev.project.service.impl.DepartmentServiceImpl;
import com.skobeev.project.service.impl.EmployeeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Transformer {

    private DepartmentService departmentService = new DepartmentServiceImpl();
    private DeleteService deleteService = new DeleteServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private Employee employee = new Employee();
    private Department department = new Department();
    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public void deleteDepartment(HttpServletRequest req) throws CustomException {
        deleteService.delete(department, Long.parseLong(req.getParameter("id")));
    }

    public void deleteEmployee(HttpServletRequest req) throws CustomException {
        deleteService.delete(employee, Long.parseLong(req.getParameter("id")));
    }

    public Employee getEmployeeById(HttpServletRequest req) throws CustomException {
        if (!req.getParameterMap().isEmpty()) {
            employee = employeeService.getEmployeeById(Long.parseLong(req.getParameter("id")));
        }
        return employee;
    }

    public void saveEmployee(HttpServletRequest req) throws CustomException {
        if (!req.getParameter("id").equals("")) {
            employee.setId(Long.parseLong(req.getParameter("id")));
        }
        employee.setEmployeeName(req.getParameter("name"));
        employee.setEmployeeSurname(req.getParameter("surname"));
        employee.setEmployeeEmail(req.getParameter("email"));
        try {
            employee.setEmployeeBirthday(format.parse(req.getParameter("birthday")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setEmployeeSalary(Long.parseLong(req.getParameter("salary")));
        employee.setDepartmentId(Long.parseLong(req.getParameter("departmentId")));

        employeeService.saveEmployee(employee);
    }

    public Department getDepListDyId(HttpServletRequest req) throws CustomException {

        if (!req.getParameterMap().isEmpty()) {
            department = departmentService.getDepartmentListById(Long.parseLong(req.getParameter("id")));
        }
        return department;
    }

    public void saveDepartment(HttpServletRequest req) throws CustomException {
        if (!req.getParameter("id").equals("")) {
            department.setId(Long.parseLong(req.getParameter("id")));
        }
        department.setDepartmentName(req.getParameter("name"));
        departmentService.saveDepartment(department);
    }
}
