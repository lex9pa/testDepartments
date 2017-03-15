package com.skobeev.project.constants;

public class QueryConstants {
    public static final String GET_EMPLOYEE_LIST = "select * FROM employee";
//    public static final String GET_EMPLOYEE_LIST_BY_DEP_ID = "select * FROM employee WHERE department_id = ?";
    public static final String CREATE_EMPLOYEE = "INSERT INTO employee (employee_name,employee_surname,employee_birthday,employee_salary,employee_email,department_id) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_EMPLOYEE = "UPDATE employee set employee_name=?, employee_surname=?,employee_birthday=?,employee_salary=?,employee_email=?,department_id=? where id=?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id=?";
    public static final String SELECT_EMPLOYEE_ID = "select * FROM employee where id=?";


    public static final String DELETE_DEPARTMENT = "DELETE FROM department WHERE id=?";
    public static final String GET_DEPARTMENT_LIST = "select * FROM department";
    public static final String CREATE_DEPARTMENT = "INSERT INTO department (department_name) VALUES (?)";
    public static final String UPDATE_DEPARTMENT = "UPDATE department set department_name=? where id=?";
    public static final String SELECT_DEPARTMENT_ID = "select * FROM department where id=?";
}
