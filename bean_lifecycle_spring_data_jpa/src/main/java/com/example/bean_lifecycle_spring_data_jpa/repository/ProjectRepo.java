package com.example.bean_lifecycle_spring_data_jpa.repository;

import com.example.bean_lifecycle_spring_data_jpa.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long> {
    List<Project> findByNameContains(String infix);
}
