package com.example.bean_lifecycle_spring_data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    //we also have LocalDateTime
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy")
    private LocalDate dob;

    @Transient
    private int age;

    @Lob
    private String about_employee;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    only when i need to update the department though employee but usually the the parent will not be updated from child entity
//    there are two way ine is without cascade othera is with cascade
    @ManyToOne
    @JoinColumn(name = "dept_id")
    @JsonBackReference("dept-emp")
//    i need to give the value from the owning side(this is the owning side)
    private Department department;

//    while in post method because its @ManyToMany(and this is applicable for only @manyToMany) either i can give the details from employee or project json both are valid
    @ManyToMany(mappedBy = "employees") //employee is the field name in the projects
//    no clear parent for many-to-many
//    @JsonManagedReference("emp-project")
//  don't use this json can't identify which is parent and which side is child in many to many so use jsonignore
    @JsonIgnore
    private List<Project> projects;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Transient
    public int getAge() {
        if(dob == null) return 0;
        return Period.between(dob,LocalDate.now()).getYears();
    }
//removing set age as I calculate the age getAge only
//    public void setAge(int age) {
//        this.age = age;
//    }

    public String getAbout_employee() {
        return about_employee;
    }

    public void setAbout_employee(String about_employee) {
        this.about_employee = about_employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
