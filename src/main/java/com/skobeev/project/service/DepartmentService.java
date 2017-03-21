package com.skobeev.project.service;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.exception.ValidationException;
import com.skobeev.project.model.Department;

import java.util.List;

public interface DepartmentService {

    void delete(Object ob, Long id) throws CustomException;

    List<Department> getDepartmentList() throws CustomException;

    void saveDepartment(Department department) throws CustomException, ValidationException;

    Department getDepartmentListById(Long id) throws CustomException;

    Department getDepartmentByName(String department_name) throws CustomException;
}
