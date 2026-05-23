package com.example.Spring.MVC.Features.dto;

import com.example.Spring.MVC.Features.validationGroup.CreateEmployee;
import com.example.Spring.MVC.Features.validationGroup.UpdateEmployee;
import jakarta.validation.constraints.NotNull;

//always remember getter and setters are required otherwise i will receive the null value
//JSON request body values into the object fields without setters, so all fields remain null.
public class EmployeeValidatedDTO {

    @NotNull(groups = UpdateEmployee.class, message = "employee id is must for updating Employee details")
    private String empId;

    @NotNull(groups = {UpdateEmployee.class, CreateEmployee.class},message = "the employee name is required")
    private String empName;

    @NotNull(groups = CreateEmployee.class, message = "password is required")
    private String empPassword;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }
}
