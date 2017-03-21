package com.skobeev.project.model;

import com.skobeev.project.util.validation.EmployeeMailValidation;
import net.sf.oval.constraint.*;

import java.util.Date;

public class Employee {
    private Long Id;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Length(min = 3, max = 20, message = "Name length must between 3 and 20")
    private String employeeName;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Length(min = 3, max = 20, message = "Name length must between 3 and 20")
    private String employeeSurname;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @DateRange(format = "yyyy-MM-dd", min = "1950-01-01", max = "2000-01-01", message = "Birthday must be in a range of 1950-2000")
    private Date employeeBirthday;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 1000, message = "Invalid value,minimum salary must be 1000")
    private Long employeeSalary;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @CheckWith(value = EmployeeMailValidation.class, message = "such a e-mail already exists")
    private String employeeEmail;

    private Long departmentId;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
