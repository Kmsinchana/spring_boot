package com.example.bean_lifecycle_spring_data_jpa.service;

import com.example.bean_lifecycle_spring_data_jpa.entity.Department;
import com.example.bean_lifecycle_spring_data_jpa.entity.Employee;
import com.example.bean_lifecycle_spring_data_jpa.repository.DepartmentRepo;
import com.example.bean_lifecycle_spring_data_jpa.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final EmployeeRepo employeeRepo;

    public DepartmentService(DepartmentRepo departmentRepo, EmployeeRepo employeeRepo) {
        this.departmentRepo = departmentRepo;
        this.employeeRepo= employeeRepo;
    }

    public Department saveDepartment(Department department){
        return departmentRepo.save(department);
    }

    public List<Department> getAllDepartment(){
        return departmentRepo.findAll();
    }

//its always recommended to add both side updation in the code we can
    public Department updateDepartment(Long id, Department department){
        Department finddept = departmentRepo.findById(id).orElseThrow(()-> new RuntimeException("can't find the department"));
        finddept.setName(department.getName());
        finddept.setEmail(department.getEmail());
//        to update a employee and project fields
//        method 1 with cascade
        if(department.getEmployees()!= null){

            finddept.getEmployees().clear(); //orphan removal will delete the old employee
//with cascade we did not call childrepo.save()(employeerepo.save())not required it will be done automatically
            for(Employee emp:department.getEmployees()){
               emp.setDepartment(finddept); //owning side updation

                //inverse side optional but need to do for in memory consistency, we get proper response only when we reload the details id we did not add this line
                finddept.getEmployees().add(emp); //adding the employee details to the department one by one
            }

            //i can update the project in the same way
        }
      //  “In a bidirectional relationship, only the owning side controls the database update.
        //  The inverse side is used for navigation and must be updated manually to keep the in-memory object graph consistent.
        //  So in practice, we always update the owning side and optionally synchronize the inverse side.”

        //method 2 without cascade
//        if (department.getEmployees() != null) {
//
//            List<Employee> updatedEmployees = new ArrayList<>();
//
//            for (Employee emp : department.getEmployees()) {
//
//                Employee existingEmployee = employeeRepo.findById(emp.getId())
//                        .orElseThrow(() -> new RuntimeException("Employee not found: " + emp.getId()));
//
//                existingEmployee.setName(emp.getName());
//                existingEmployee.setEmail(emp.getEmail());
//                existingEmployee.setDob(emp.getDob());
//                existingEmployee.setAbout_employee(emp.getAbout_employee());
//
//                // ✅ owning side update
              // This line is the most important one
               //👉 This alone updates the database correctly
//                existingEmployee.setDepartment(finddept);
//
         //inverse side update
             //  👉 This is just for:
        // Keeping Java object consistent
//       // Returning correct API response

//                updatedEmployees.add(existingEmployee);
//            }
//
//            finddept.setEmployees(updatedEmployees);
//        }

        //update project in the same way
        return departmentRepo.save(finddept);
    }

//    we use .remove() method in hibernate jpa  but in jpa repository we use .delete()
    public void deleteDepartment(Long id){
//        departmentRepo.deleteById(id);
//        the above way will not check if the department present or not
        Department deletDepartment = departmentRepo.findById(id).orElseThrow(()-> new RuntimeException("the department not found"));
        departmentRepo.delete(deletDepartment);
    }
}
