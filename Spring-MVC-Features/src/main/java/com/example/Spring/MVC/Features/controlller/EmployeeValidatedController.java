package com.example.Spring.MVC.Features.controlller;

import com.example.Spring.MVC.Features.dto.EmployeeValidatedDTO;
import com.example.Spring.MVC.Features.uncheckedException.EmployeeNotFoundException;
import com.example.Spring.MVC.Features.validationGroup.CreateEmployee;
import com.example.Spring.MVC.Features.validationGroup.UpdateEmployee;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp/validation")
@Validated
public class EmployeeValidatedController {

//    all dto related exception will throw MethodArgumentNotValidException
    //    validation of groups example
    @PostMapping
    public String createEmployee(@Validated(CreateEmployee.class) @RequestBody EmployeeValidatedDTO employeeValidatedDTO){
        return "Employee Created";
    }

    @PutMapping
    public String updateEmployee(@Validated(UpdateEmployee.class) @RequestBody EmployeeValidatedDTO employeeValidatedDTO){
        return "Employee updated successfully";
    }
// validating the pathVariable (this will use the Validation mentioned above the name of the controller)
//    path variable and request param will result in ConstraintViolationException
    @GetMapping("/{id}")
    public String getEmployee(@PathVariable @Positive(message = "The value should be greater than 1") Long id){
        return "Product id: "+id;
    }

    @GetMapping("/empById/{id}")
    public String findEmployeeById(@PathVariable Long id){
        if(id==10){
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return "employee found";
    }
}

