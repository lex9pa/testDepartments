package com.skobeev.project.service.impl;

import com.skobeev.project.dao.DepartmentDao;
import com.skobeev.project.dao.impl.DepartmentDaoImpl;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;
import com.skobeev.project.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    public List<Department> getDepartmentList() throws CustomException {
        return departmentDao.getDepartmentList();
    }

    public void saveDepartment(Department department) throws CustomException {
        departmentDao.saveDepartment(department);
    }

    public Department getDepartmentListById(Long id) throws CustomException {
        return departmentDao.getDepartmentListById(id);
    }
}
