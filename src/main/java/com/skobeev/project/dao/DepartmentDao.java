package com.skobeev.project.dao;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> getDepartmentList() throws CustomException;

    void saveDepartment(Department department);

    void deleteDepartment(Long departmentId);

    Department getDepartmentListById(Long id);
}
