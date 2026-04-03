package com.example.bean_lifecycle_spring_data_jpa.controller;

import com.example.bean_lifecycle_spring_data_jpa.entity.Department;
import com.example.bean_lifecycle_spring_data_jpa.service.DepartmentService;
import jakarta.websocket.server.PathParam;
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

    @GetMapping("/{name}")
    public List<Department> getDepartmentName(@PathVariable String name){
        return departmentService.fetchTheDepartmentName(name);
    }
//    to fetch the department details with employee email
    @GetMapping("/empemail/{email}")
    public List<Department> findDepartmentByEmployeeEmail(@PathVariable String email){
        return departmentService.findDepartmentThroughEmployeeEmail(email);
    }

//    update the department email
//    in request body we have to pass the dto otherwise to pass the single field the request body will take whole json not only email
//    so we can use the path only
    @PatchMapping("/{id}/{email}")
    public int updateEmail(@PathVariable Long id, @PathVariable String email){
        return departmentService.updateDepartmentEmail(id,email);
    }

//    list of department for n+1 problem
    @GetMapping("/NPlus1problem")
    public List<Department> getDepartment(){
        return departmentService.getAllDeptWithJpql();
    }
}
