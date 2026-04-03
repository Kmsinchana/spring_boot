package com.example.bean_lifecycle_spring_data_jpa.controller;

import com.example.bean_lifecycle_spring_data_jpa.entity.Employee;
import com.example.bean_lifecycle_spring_data_jpa.entity.Project;
import com.example.bean_lifecycle_spring_data_jpa.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    private List<Project> getProject(){
        return projectService.getAllProject();
    }

    @PostMapping
    private Project saveProject(@RequestBody Project project){
        return projectService.saveProject(project);
    }

    @PutMapping("/{id}")
    private Project updateProject(@PathVariable Long id, @RequestBody Project project){
        return projectService.updateProject(id,project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }

    @GetMapping("/{infix}")
    public List<Project> getProjectWhichNameContains(@PathVariable String infix){
        return projectService.fetchTheInfixProjectName(infix);
    }
}
