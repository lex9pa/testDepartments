package com.skobeev.project.util.validation;

import com.skobeev.project.exception.CustomException;
import com.skobeev.project.model.Department;
import com.skobeev.project.service.DepartmentService;
import com.skobeev.project.service.impl.DepartmentServiceImpl;
import net.sf.oval.constraint.CheckWithCheck;

public class DepartmentNameValidation implements CheckWithCheck.SimpleCheck {

    public boolean isSatisfied(Object validatedObject, Object value) {

        DepartmentService departmentService = new DepartmentServiceImpl();
        Department department = null;
        if (validatedObject instanceof Department) {
            try {
                department = departmentService.getDepartmentByName(value.toString());
                if (((Department) validatedObject).getId() != null) {
                    if (((Department) validatedObject).getId().equals(department.getId())) {
                        return true;
                    }
                }
            } catch (CustomException ignored) {
            }
        }
        return (department != null ? department.getId() : null) == null;
    }
}
