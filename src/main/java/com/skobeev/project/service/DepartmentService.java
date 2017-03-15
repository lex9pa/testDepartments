package com.skobeev.project.service;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartmentList() throws CustomException;

    void saveDepartment(Department department) throws CustomException;

    Department getDepartmentListById(Long id) throws CustomException;
}
