package com.pothu.springbootpractice.controller;

import com.pothu.springbootpractice.entity.Department;
import com.pothu.springbootpractice.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @PostMapping("/add")
    public Department addDepartment(@Valid @RequestBody Department department){
        System.out.println(department.toString());
       return departmentService.addDepartment(department);
    }

    @GetMapping("/get/{departmentId}")
    public Department getDepartmentById(@PathVariable("departmentId") long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping("/get/all")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }


    @DeleteMapping("/delete/{departmentId}")
    public void deleteDepartmentById(@PathVariable long departmentId){
        departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("/update/{id}")
    public void updateDepartment(@RequestBody Department department,@PathVariable long id){
        department.setDepartmentId(id);
        departmentService.updateDepartment(department);
    }

    @GetMapping("/name/{departmentName}")
    public Department getDepartmentByName(@PathVariable("departmentName") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }

}
