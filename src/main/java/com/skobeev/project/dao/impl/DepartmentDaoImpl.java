package com.skobeev.project.dao.impl;

import com.skobeev.project.dao.DepartmentDao;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;
import com.skobeev.project.util.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.skobeev.project.constants.QueryConstants.*;

public class DepartmentDaoImpl implements DepartmentDao {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public List<Department> getDepartmentList() throws CustomException {
        List<Department> listDepartment = new ArrayList<Department>();
        connection = DBConnector.getConnection();
        ResultSet resultSet;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_DEPARTMENT_LIST);
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getLong("id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                listDepartment.add(department);
            }
        } catch (SQLException e) {
            throw new CustomException("Can't get department list, please try again later");
        } finally {
            DBConnector.closeConnection(connection);
        }
        return listDepartment;
    }


    public void saveDepartment(Department department) throws CustomException {
        connection = DBConnector.getConnection();
        try {
            if (department.getId() == null) {
                preparedStatement = connection.prepareStatement(CREATE_DEPARTMENT);
                preparedStatement.setString(1, department.getDepartmentName());
            } else {
                preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT);
                preparedStatement.setLong(2, department.getId());
                preparedStatement.setString(1, department.getDepartmentName());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Can't save department, please try again later");
        } finally {
            DBConnector.closeConnection(connection);
        }

    }

    public Department getDepartmentListById(Long id) throws CustomException {
        Department department = new Department();
        connection = DBConnector.getConnection();
        try {
            preparedStatement = connection.prepareStatement(SELECT_DEPARTMENT_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                department.setId(resultSet.getLong("id"));
                department.setDepartmentName(resultSet.getString("department_name"));
            }
        } catch (SQLException e) {
            throw new CustomException("Can't get department list, please try again later");
        } finally {
            DBConnector.closeConnection(connection);
        }
        return department;
    }

    public Department getDepartmentByName(String department_name) throws CustomException {
        Department department = new Department();
        connection = DBConnector.getConnection();
        try {
            preparedStatement = connection.prepareStatement(SELECT_DEPARTMENT_BY_NAME);
            preparedStatement.setString(1, department_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                department.setId(resultSet.getLong("id"));
            }
        } catch (Exception e) {
            throw new CustomException("Can't get department list, please try again later");
        } finally {
            DBConnector.closeConnection(connection);
        }
        return department;
    }

}
