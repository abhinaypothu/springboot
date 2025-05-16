package com.pothu.springbootpractice.service;

import com.pothu.springbootpractice.entity.Department;
import com.pothu.springbootpractice.error.DepartmentNotFoundException;
import com.pothu.springbootpractice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    public DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(long departmentId) throws DepartmentNotFoundException {
        Optional<Department>o = departmentRepository.findById(departmentId);
        if(!o.isPresent()){throw new DepartmentNotFoundException("Department not found with id: "+departmentId);};
        return o.get();
    }

    @Override
    public void deleteDepartmentById(long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.saveAndFlush(department);
    }
    @Override
    public Department getDepartmentByName(String departmentName){
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
