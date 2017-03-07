package com.skobeev.project.dao;

import com.skobeev.project.model.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> getDepartmentList();

    void saveDepartment(Department department);

    void deleteDepartment(Long departmentId);

    Department getDepartmentListById(Long id);
}
