package com.example.AopAndTransaction.service;

import com.example.AopAndTransaction.entity.Department;
import com.example.AopAndTransaction.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department){
        return departmentRepo.save(department);
    }

//    pagination implementation
    public Page<Department> getDepartmentByPage(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return departmentRepo.findAll(pageable);
    }
    //implementation with slice(fast compare to page<T> doesn't give page count) no count' query
    public Slice<Department> getDepartmentByPageWithSlice(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return departmentRepo.findAll(pageable);
    }
//    list
    public List<Department> getDepartmentByPageWithList(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return departmentRepo.findAll(pageable).getContent(); //it only return the content
    }

    public Page<Department> sortDepartmentWithPagination(int pageNo, int pageSize, String sortBy, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase("asc")?
                    Sort.by(sortBy).ascending():
                    Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        return departmentRepo.findAll(pageable);
    }


}
