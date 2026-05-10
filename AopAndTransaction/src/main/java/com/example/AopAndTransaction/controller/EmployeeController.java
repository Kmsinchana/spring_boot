package com.example.AopAndTransaction.controller;

import com.example.AopAndTransaction.entity.Employee;
import com.example.AopAndTransaction.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PutMapping
//    @Transactional
    public ResponseEntity<?> transferEmployee(@RequestParam Long empId, @RequestParam Long deptId){
        try {
            employeeService.transferEmployee(empId,deptId);
            return ResponseEntity.ok("the transfer is done successfully");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Transfer failed"+e.getMessage());
        }
    }

//    sort the employee by name
    @GetMapping("/sort")
    public List<Employee> sortEmployee(@RequestParam String sortBy,String sortDir){
        return employeeService.sortEmployee(sortBy,sortDir);
    }

//    get employee with department
    @GetMapping("/usingJpqlwithpageable")
    public Page<Employee> getEmployeeByDepartmentName(@RequestParam String deptName,
                                                      @RequestParam(defaultValue = "0") int pageNo,
                                                      @RequestParam(defaultValue = "5") int pageSize,
                                                      @RequestParam(defaultValue = "name") String sortBy){
        return employeeService.getEmployeeWithDepartmentName(deptName,pageNo,pageSize,sortBy);
    }
}
