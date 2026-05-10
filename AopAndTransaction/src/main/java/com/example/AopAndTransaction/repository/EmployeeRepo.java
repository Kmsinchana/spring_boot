package com.example.AopAndTransaction.repository;


import com.example.AopAndTransaction.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    //    using pagination and sorting with Jpql Query
    @Query("select e from Employee e where e.department.name=:deptName")
    Page<Employee> findEmployeeWithDeptName(String deptName, Pageable pageable);
}
