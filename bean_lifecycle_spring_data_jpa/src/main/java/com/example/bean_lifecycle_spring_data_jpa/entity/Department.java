package com.example.bean_lifecycle_spring_data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
//An index is a data structure used by the database to find rows faster.
//index will get created
//Search index
//↓
//Find row id
//↓
//Fetch record

//the getter and setter are important, jackson use this for serialization(Java Object → JSON) and deserialization(JSON → Java Object)
//If no getter and setter we get null for all the requestbody field when we debug
@Table(name = "Departments",indexes = {@Index(name = "idx_dept_name",columnList = "dept_name,email")})
public class Department {

    @Id
//    there are 4 more other ways
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    when we are giving json field we need to enter name only if we want to same name as @column name then we need to add jackson annotation
    @Column(name = "dept_name",length = 100,nullable = false)
//    jackson annotation for json when we nee to give this value only in json
//    if the json property name does not match with json bod we are giving the field will receive null
//    if json property not added then in json body i need to send name id json property i add then i need to add the name as json property
    @JsonProperty("dept_name")
    private String name;
   @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "department" ,cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference("dept-emp")
//    parent side (The parent side is the one that contains the collection.)
    private List<Employee> employees;

//    if mappedby is present its inverse side so the projects manages it
    @OneToMany(mappedBy = "department")
    @JsonManagedReference("dept-project")
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

