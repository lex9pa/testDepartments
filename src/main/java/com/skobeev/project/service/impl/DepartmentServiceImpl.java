package com.skobeev.project.service.impl;

import com.skobeev.project.dao.CommonDelete;
import com.skobeev.project.dao.DepartmentDao;
import com.skobeev.project.dao.impl.CommonDeleteImpl;
import com.skobeev.project.dao.impl.DepartmentDaoImpl;
import com.skobeev.project.exception.CustomException;
import com.skobeev.project.exception.ValidationException;
import com.skobeev.project.model.Department;
import com.skobeev.project.service.DepartmentService;
import com.skobeev.project.util.validation.ValidationModel;

import java.util.List;
import java.util.Map;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    private ValidationModel validator = new ValidationModel();

    private CommonDelete commonDelete = new CommonDeleteImpl();

    public void delete(Object ob, Long id) throws CustomException {
        commonDelete.delete(ob, id);
    }

    public List<Department> getDepartmentList() throws CustomException {
        return departmentDao.getDepartmentList();
    }

    public void saveDepartment(Department department) throws CustomException, ValidationException {
        Map<String, List<String>> errorMap = validator.validateObjects(department);
        if (errorMap.isEmpty()) {
            departmentDao.saveDepartment(department);
        } else
            throw new ValidationException(errorMap);
    }

    public Department getDepartmentListById(Long id) throws CustomException {
        return departmentDao.getDepartmentListById(id);
    }

    public Department getDepartmentByName(String department_name) throws CustomException {
        return departmentDao.getDepartmentByName(department_name);
    }
}
