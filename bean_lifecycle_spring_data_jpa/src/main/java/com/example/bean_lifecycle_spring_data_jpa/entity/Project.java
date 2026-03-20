package com.example.bean_lifecycle_spring_data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    if we need to add column field extra for the new table we can't do with this method
//    Employee 1 --- * EmployeeProject * --- 1 Project need to create new table as EmployeeProject with have many-to-one relationship with project and employee
    @ManyToMany
    @JoinTable(
            name = "emp_project",
            joinColumns = @JoinColumn(name = "proj_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id")
    )
    private List<Employee> employees;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    @JsonBackReference("dept-project")
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
