package com.example.bean_lifecycle_spring_data_jpa.controller;

import com.example.bean_lifecycle_spring_data_jpa.entity.Department;
import com.example.bean_lifecycle_spring_data_jpa.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department saveDept(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getDept(){
        return departmentService.getAllDepartment();
    }

    @PutMapping("/{id}")
    public Department updateDept(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }

    @DeleteMapping("/{id}")
    public void deleteDept(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }
}
