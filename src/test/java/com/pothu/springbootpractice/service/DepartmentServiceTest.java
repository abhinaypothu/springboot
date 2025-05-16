package com.pothu.springbootpractice.service;

import com.pothu.springbootpractice.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void whenValidDepartmentName_ThenDepartmentShouldFound(){
        String departmentName = "IT";

        Department department = departmentService.getDepartmentByName(departmentName);

        assertNull(department);

    }
}