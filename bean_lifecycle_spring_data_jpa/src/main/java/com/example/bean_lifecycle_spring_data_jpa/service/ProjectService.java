package com.example.bean_lifecycle_spring_data_jpa.service;

import com.example.bean_lifecycle_spring_data_jpa.entity.Department;
import com.example.bean_lifecycle_spring_data_jpa.entity.Employee;
import com.example.bean_lifecycle_spring_data_jpa.entity.Project;
import com.example.bean_lifecycle_spring_data_jpa.repository.DepartmentRepo;
import com.example.bean_lifecycle_spring_data_jpa.repository.EmployeeRepo;
import com.example.bean_lifecycle_spring_data_jpa.repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final DepartmentRepo departmentRepo;
    private final EmployeeRepo employeeRepo;

    public ProjectService(ProjectRepo projectRepo, DepartmentRepo departmentRepo, EmployeeRepo employeeRepo) {
        this.projectRepo = projectRepo;
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
    }

    public Project saveProject(Project project){
        return projectRepo.save(project);
    }

    public List<Project> getAllProject(){
        return projectRepo.findAll();
    }

    public Project updateProject(Long id, Project project){
        Project findProject = projectRepo.findById(id).orElseThrow(()-> new RuntimeException("no such project found"));
        findProject.setName(project.getName());
//        this will not update the detartment details it only update the  department connection only
        if(project.getDepartment()!=null){
            Department getDepartment = departmentRepo.findById(project.getDepartment().getId()).orElseThrow(()->new RuntimeException("No department found"));
            findProject.setDepartment(getDepartment);
        }
        // employees validation
        if(project.getEmployees() != null){

            List<Long> empIds = project.getEmployees()
                    .stream()
                    .map(Employee::getId)
                    .toList();

            List<Employee> employees = employeeRepo.findAllById(empIds);

            if(employees.size() != empIds.size()){
                throw new RuntimeException("One or more employees not found");
            }

            findProject.setEmployees(employees);
        }
        return projectRepo.save(findProject);
    }

    public void deleteProject(Long id){
        Project deleteProject = projectRepo.findById(id).orElseThrow(()-> new RuntimeException("the project not found"));
        projectRepo.delete(deleteProject);
    }

    public List<Project> fetchTheInfixProjectName(String name){
      return  projectRepo.findByNameContains(name);
    }
}
