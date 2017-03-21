package com.skobeev.project.model;


import com.skobeev.project.util.validation.DepartmentNameValidation;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class Department {
    private Long id;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Length(min = 3, max = 20, message = "Name length must between 4 and 20")
    @CheckWith(value = DepartmentNameValidation.class, message = "such a name already exists")
    private String departmentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
