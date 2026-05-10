package com.example.AopAndTransaction.controller;

import com.example.AopAndTransaction.entity.Department;
import com.example.AopAndTransaction.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aop")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department saveDept(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

//implementing the pagination alone
    @GetMapping("/pagination")
    public Page<Department> getDepartmentPageByPage(@RequestParam int pageNo, @RequestParam int pageSize){
        return departmentService.getDepartmentByPage(pageNo,pageSize);
    }
//    the o/p we got for this
//{
//    "content": [
//    ],
//    "pageable": {
//    "pageNumber": 0,
//            "pageSize": 5,
//            "sort": {
//        "empty": true,
//                "sorted": false,
//                "unsorted": true
//    },
//    "offset": 0,
//            "paged": true,
//            "unpaged": false
//},
//    "last": false,
//        "totalPages": 2,
//        "totalElements": 8,
//        "size": 5,
//        "number": 0,
//        "sort": {
//    "empty": true,
//            "sorted": false,
//            "unsorted": true
//},
//    "numberOfElements": 5,
//        "first": true,
//        "empty": false
//}

    //with slice
    @GetMapping("/slice")
    public Slice<Department> getDepartmentByPageWithSlice(@RequestParam int pageNo, @RequestParam int pageSize){
        return departmentService.getDepartmentByPageWithSlice(pageNo,pageSize);
    }
//    {
//        "content": [
//    ],
//        "pageable": {
//        "pageNumber": 0,
//                "pageSize": 5,
//                "sort": {
//            "empty": true,
//                    "sorted": false,
//                    "unsorted": true
//        },
//        "offset": 0,
//                "paged": true,
//                "unpaged": false
//    },
//        "last": false,
//            "totalPages": 2,
//            "totalElements": 8,
//            "first": true,
//            "size": 5,
//            "number": 0,
//            "sort": {
//        "empty": true,
//                "sorted": false,
//                "unsorted": true
//    },
//        "numberOfElements": 5,
//            "empty": false
//    }

//    List
    @GetMapping("/list")
    public List<Department> getDepartmentByPageWithList(@RequestParam int pageNo, @RequestParam int pageSize){
        return departmentService.getDepartmentByPageWithList(pageNo,pageSize);
    }

//    implementing sor and pagination together
    @GetMapping("/sortWithPagination")
    public Page<Department> sortDepartmentWithPagination(@RequestParam(defaultValue = "0") int pageNo,
                                                         @RequestParam(defaultValue = "5") int pageSize,
                                                         @RequestParam(defaultValue = "name") String sortBy,
                                                         @RequestParam(defaultValue = "asc") String sortDir){
        return departmentService.sortDepartmentWithPagination(pageNo,pageSize,sortBy,sortDir);
    }
}
