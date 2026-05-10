package com.example.AopAndTransaction.service;

import com.example.AopAndTransaction.entity.Department;
import com.example.AopAndTransaction.entity.Employee;
import com.example.AopAndTransaction.repository.DepartmentRepo;
import com.example.AopAndTransaction.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    //transferring employee from one department to other department
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
    public void transferEmployee(Long empId, Long deptId){
//        get employee details
        Employee emp = employeeRepo.findById(empId).orElseThrow(()-> new RuntimeException("the employee not found"));
         //get old department
        Department oldDept = emp.getDepartment();
//       get new department details
        Department newDept = departmentRepo.findById(deptId).orElseThrow(()-> new RuntimeException("the department not found"));

//        removing the employee details from old department
        oldDept.getEmployees().remove(emp);

//        adding new department details to the employee
        emp.setDepartment(newDept);
//        adding employee details to the department
        newDept.getEmployees().add(emp);

//        saving changes is important
        employeeRepo.save(emp);
        departmentRepo.save(oldDept);
        departmentRepo.save(newDept);
//      intentionally adding the exception after the database save
        if (true){
            throw new RuntimeException("checking the roll back exception");
        }
    }

//    sort employee by name
   public List<Employee> sortEmployee(String sortBy, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase("asc")?
                    Sort.by(sortBy).ascending():
                    Sort.by(sortBy).descending();
        return employeeRepo.findAll(sort);
    }
//    get employee with department
   public Page<Employee> getEmployeeWithDepartmentName(String deptName, int pageNo, int pageSize, String sortBy){
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(sortBy));
        return employeeRepo.findEmployeeWithDeptName(deptName,pageable);
    }
}
