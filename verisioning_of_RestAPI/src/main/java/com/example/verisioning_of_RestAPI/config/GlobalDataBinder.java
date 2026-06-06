package com.example.verisioning_of_RestAPI.config;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalDataBinder {

//    this is not support when we use @RequestBody as for accepting json input reason:
// @InitBinder customizes Spring MVC data binding. For @RequestBody JSON payloads, Jackson performs deserialization before Spring binding occurs. In such cases, @JsonFormat, custom Jackson serializers/deserializers, or global ObjectMapper configuration should be used.
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
