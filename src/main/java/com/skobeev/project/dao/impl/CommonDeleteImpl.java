package com.skobeev.project.dao.impl;

import com.skobeev.project.dao.CommonDelete;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Employee;
import com.skobeev.project.util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.skobeev.project.constants.QueryConstants.DELETE_DEPARTMENT;
import static com.skobeev.project.constants.QueryConstants.DELETE_EMPLOYEE;

public class CommonDeleteImpl implements CommonDelete {

    public void delete(Object ob, Long id) throws CustomException {
        Connection connection = DBConnector.getConnection();
        PreparedStatement preparedStatement;
        try {
            if (ob instanceof Employee) {
                preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            } else {
                preparedStatement = connection.prepareStatement(DELETE_DEPARTMENT);
            }
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Can't delete department, please try again later");
        } finally {
            DBConnector.closeConnection(connection);
        }
    }
}
