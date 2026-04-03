package com.example.bean_lifecycle_spring_data_jpa.controller;


import com.example.bean_lifecycle_spring_data_jpa.dto.DeptCountDTO;
import com.example.bean_lifecycle_spring_data_jpa.entity.Employee;
import com.example.bean_lifecycle_spring_data_jpa.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    private List<Employee> getEmployee(){
       return employeeService.getAllEmployee();
    }

    @PostMapping
    private Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    private Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/employeeExists")
//    IMP
//    don't use @request body with get it will not pass the email value correctly, it pass incorrectly either use path variable or request param
    public Boolean checkEmployeeExists(@RequestParam String email){
        return employeeService.checkEmployeeEmailExistsOrNot(email);
    }
//    find the employee by the department email
    @GetMapping("/deptemail/{email}")
    public List<Employee> findEmployeeDetailsDetailsByDepartmentEmail(@PathVariable String email){
        return employeeService.fetchEmployeeDetailsFromDepartmentEmail(email);
    }
//    find all employee name
    @GetMapping("/getallname")
    public List<String> findALLEmployeeName(){
        return employeeService.findAllEmployeeName();
    }

    @GetMapping("/{getcount}")
    public List<DeptCountDTO> countofemployee(){
        return employeeService.findCountOfEmployee();
    }
}
