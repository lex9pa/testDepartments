package com.skobeev.project.dao.impl;

import com.skobeev.project.dao.EmployeeDao;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Employee;
import com.skobeev.project.util.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.skobeev.project.constants.QueryConstants.*;

public class EmployeeDaoImpl implements EmployeeDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public List<Employee> getEmployeeList() throws CustomException {
        List<Employee> listEmployee = new ArrayList<Employee>();
        connection = DBConnector.getConnection();
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_EMPLOYEE_LIST);
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
            throw new CustomException("Can't get employee list, please try again later");
        } finally {
            DBConnector.closeConnection(connection);
        }
        return listEmployee;
    }

    public void saveEmployee(Employee employee) throws CustomException {

        connection = DBConnector.getConnection();
        try {
            if (employee.getId() == null) {
                preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE);
            } else {
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
            throw new CustomException("Can't save employee, please try again later");
        } finally {
            DBConnector.closeConnection(connection);
        }
    }

    public Employee getEmployeeById(Long id) throws CustomException {
        Employee employee = new Employee();
        connection = DBConnector.getConnection();
        try {
            preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getLong("id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeSurname(resultSet.getString("employee_surname"));
                employee.setEmployeeBirthday(resultSet.getDate("employee_birthday"));
                employee.setEmployeeSalary(resultSet.getLong("employee_salary"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setDepartmentId(resultSet.getLong("department_id"));
            }
        } catch (SQLException e) {
            throw new CustomException("Can't get employee list, please try again later");
        } finally {
            DBConnector.closeConnection(connection);
        }
        return employee;
    }

    public Employee getEmployeeByMail(String employeeEmail) throws CustomException {
        connection=DBConnector.getConnection();
        Employee employee=new Employee();
        try {
            preparedStatement=connection.prepareStatement(SELECT_EMPLOYEE_MAIL);
            preparedStatement.setString(1, employeeEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            throw new CustomException("Can't get employee list, please try again later");
        }finally {
            DBConnector.closeConnection(connection);
        }
        return employee;
    }
}
