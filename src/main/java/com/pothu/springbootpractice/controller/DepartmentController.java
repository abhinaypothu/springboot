package com.pothu.springbootpractice.controller;

import com.pothu.springbootpractice.entity.Department;
import com.pothu.springbootpractice.error.DepartmentNotFoundException;
import com.pothu.springbootpractice.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;
    @PostMapping("/add")
    public Department addDepartment(@Valid @RequestBody Department department){
        System.out.println(department.toString());
        logger.info("addDepartment: {}",department);
        return departmentService.addDepartment(department);
    }

    @GetMapping("/get/{departmentId}")
    public Department getDepartmentById(@PathVariable("departmentId") long departmentId) throws DepartmentNotFoundException {
        Department o =  departmentService.getDepartmentById(departmentId);
        return o;
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
