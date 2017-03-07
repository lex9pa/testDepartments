package com.skobeev.project.dao.impl;

import com.skobeev.project.dao.EmployeeDao;
import com.skobeev.project.model.Employee;
import com.skobeev.project.util.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.skobeev.project.constants.QueryConstants.*;

public class EmployeeDaoImpl implements EmployeeDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public List<Employee> getEmployeeList() {
        List<Employee> listEmployee = new ArrayList<Employee>();
        connection = DBConnector.getConnection();
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
//            if (departmentId == null) {
                resultSet = statement.executeQuery(GET_EMPLOYEE_LIST);
//            } else resultSet = statement.executeQuery(GET_EMPLOYEE_LIST_BY_DEP_ID);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeSurname(resultSet.getString("employee_surname"));
                employee.setEmployeeBirthday(resultSet.getDate("employee_birthday"));
                employee.setEmployeeSalary(resultSet.getLong("employee_salary"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setDepartmentId(resultSet.getLong("department_id"));
                listEmployee.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(connection);
        }


        return listEmployee;
    }

    public void saveEmployee(Employee employee) {

        connection = DBConnector.getConnection();
        try {
            if (employee.getId() == null) {
                preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE);
            }else {
                preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
                preparedStatement.setLong(7, employee.getId());
            }
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeSurname());
            preparedStatement.setObject(3, employee.getEmployeeBirthday());
            preparedStatement.setLong(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeeEmail());
            preparedStatement.setLong(6, employee.getDepartmentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void deleteEmployee(Long employeeId) {
        connection = DBConnector.getConnection();
        try {
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setLong(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
