package com.example.Spring.MVC.Features.controlller;

import com.example.Spring.MVC.Features.dto.EmployeeDTO;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    handling the exception with binding result without exception handling
//    this is the old way of handling exception because we need to repeat the same code for every method, so we use global exception for all the controller
    @PostMapping
    public String saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult result){
        if(result.hasErrors()){
            return result.getFieldErrors()
                    .stream()
                    .map(error-> error.getField()+":" +error.getDefaultMessage())
                    .toList()
                    .toString();
        }
        return "employee saved successfully";
    }
}
