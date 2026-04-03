package com.example.bean_lifecycle_spring_data_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //includes getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class DeptCountDTO {

    private String deptName;

//    count will return the Long as return type
    private Long count;
}
