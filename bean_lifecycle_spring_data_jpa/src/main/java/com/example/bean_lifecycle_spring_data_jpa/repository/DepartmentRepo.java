package com.example.bean_lifecycle_spring_data_jpa.repository;

import com.example.bean_lifecycle_spring_data_jpa.entity.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    List<Department> findByName(String name);
//    find the department details for employee email
    List<Department> findByEmployeesEmail(String email);
//    jpql query
//    without modifying we get error as below
//     Expecting a SELECT Query [org.hibernate.query.sqm.tree.select.SqmSelectStatement], but found org.hibernate.query.sqm.tree.update.SqmUpdateStatement [update Department d set d.email = ?2 where id = ?1]
    @Modifying
    @Transactional
    @Query("update Department d set d.email=?2 where id = ?1")
    int updateDepartmentEmail(Long id, String email);

//    n+1 query problem
    @Query("select d from Department d")
    List<Department> findAllDepartment();

//    //    solution
       @Query("select d from Department d Join fetch d.employees e")
    List<Department> findAllDepartmentWithJoinFetch();
}
