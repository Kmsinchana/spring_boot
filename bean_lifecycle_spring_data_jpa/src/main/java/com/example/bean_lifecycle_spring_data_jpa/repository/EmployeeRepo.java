package com.example.bean_lifecycle_spring_data_jpa.repository;

import com.example.bean_lifecycle_spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
