package com.example.bean_lifecycle_spring_data_jpa.service;

import com.example.bean_lifecycle_spring_data_jpa.dto.DeptCountDTO;
import com.example.bean_lifecycle_spring_data_jpa.entity.Department;
import com.example.bean_lifecycle_spring_data_jpa.entity.Employee;
import com.example.bean_lifecycle_spring_data_jpa.repository.DepartmentRepo;
import com.example.bean_lifecycle_spring_data_jpa.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;

    public EmployeeService(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Long id, Employee employee){
        Employee getemployee = employeeRepo.findById(id).orElseThrow(()->new RuntimeException("can't find the employee"));
        getemployee.setName(employee.getName());
        getemployee.setEmail(employee.getEmail());
        getemployee.setDob(employee.getDob());
        getemployee.setAbout_employee(employee.getAbout_employee());
        if(employee.getDepartment()!=null){
//            if i add the below line then the updation will happen without cascade
//            Department getDepartment = departmentRepo.findById(employee.getDepartment().getId()).orElseThrow(()-> new RuntimeException("no department find"));
//            getDepartment.setName(employee.getDepartment().getName());
//            getDepartment.setEmail(employee.getDepartment().getEmail());
//            getemployee.setDepartment(getDepartment); //owning side
//            getDepartment.getEmployees().add(getemployee); //inverse side
//            to check working of cascade.merge()
            getemployee.setDepartment(employee.getDepartment()); //owning side updation
//           for this we need to pass all the fields of department if we pass only id then it won't work
//            employee.getDepartment().getEmployees().add(getemployee); //inverse side updation
        }
        return employeeRepo.save(getemployee);
    }

    public void deleteEmployee(Long id){
        Employee deleteEmployee = employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("the employee not found"));
        employeeRepo.delete(deleteEmployee);
    }

    public boolean checkEmployeeEmailExistsOrNot(String email){
        return employeeRepo.existsByEmail(email);
    }

//    find the employee by the department email
    public List<Employee> fetchEmployeeDetailsFromDepartmentEmail(String email){
        return employeeRepo.findByDepartmentEmail(email);
    }

//    fetching all employee name
    public List<String> findAllEmployeeName(){
        return employeeRepo.findALLEmployeeName();
    }

//    to fetch the employee count for each department
    public  List<DeptCountDTO> findCountOfEmployee(){
        return employeeRepo.findCountOfEmployeeInDepartment();
    }
}
