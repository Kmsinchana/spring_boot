package com.example.bean_lifecycle_spring_data_jpa.repository;

import com.example.bean_lifecycle_spring_data_jpa.dto.DeptCountDTO;
import com.example.bean_lifecycle_spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    boolean existsByEmail(String email);
    List<Employee> findByDobGreaterThan(LocalDate dob);
//    need to fetch the employee details for the department email
    List<Employee> findByDepartmentEmail(String email);
    //writing the jpql query to fetch the name of employee
    @Query("select e.name from Employee e")
    List<String> findALLEmployeeName();

//    DTO projection with employee
//    to count the employee working in a department
    @Query("select new com.example.bean_lifecycle_spring_data_jpa.dto.DeptCountDTO(e.department.name, COUNT(e)) from Employee e GROUP BY e.department.name")
    List<DeptCountDTO> findCountOfEmployeeInDepartment();

//    get employee with more than one project
    @Query(value = "SELECT * FROM employee e WHERE e.id IN (SELECT ep.emp_id FROM emp_project ep GROUP BY ep.emp_id HAVING COUNT(*)>1)", nativeQuery = true)
    List<Employee> employeeWithMoreThan1Project();

//    to get the employee project using jpql query employee working on project
    @Query("select e from Employee e join projects p where p.id= :proj_id")
    List<Employee> employeeWithProject(Long proj_id);

//    employee with no project
   @Query("SELECT e FROM Employee e WHERE e.projects IS EMPTY")
   List<Employee> findEmployeesWithoutProjects();

//alternative using left join
     @Query("SELECT e FROM Employee e LEFT JOIN e.projects p WHERE p IS NULL")
    List<Employee> findEmployeesWithoutProjectsAlt();
//     using native query see mysql
}
