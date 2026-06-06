package com.example.verisioning_of_RestAPI.controller;

import com.example.verisioning_of_RestAPI.dto.SoilSampleDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soil")
public class SoilSampleController {

//need to remove jsonformat in dto class
    @PostMapping("/withinitbinder")
    public String createSample(SoilSampleDTO soilSampleDTO){
        return "Sample saved successfully"+ soilSampleDTO;
    }
    @PostMapping("/withjsonformat")
    public String createSample2(@RequestBody SoilSampleDTO soilSampleDTO){
        return "Sample saved successfully"+ soilSampleDTO;
    }
}
