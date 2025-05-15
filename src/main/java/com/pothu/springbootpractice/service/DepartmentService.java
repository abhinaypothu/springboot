package com.pothu.springbootpractice.service;

import com.pothu.springbootpractice.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department addDepartment(Department department);
    public Department getDepartmentById(long departmentId);
    public void deleteDepartmentById(long departmentId);
    public List<Department> getAllDepartments();
    public void updateDepartment(Department department);
    public Department getDepartmentByName(String departmentName);
}
