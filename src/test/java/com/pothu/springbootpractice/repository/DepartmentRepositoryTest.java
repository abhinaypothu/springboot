package com.pothu.springbootpractice.repository;

import com.pothu.springbootpractice.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department  = Department.builder()
                .departmentName("ME")
                .departmentCode("ME - 011")
                .departmentAddress("Nalanda Block")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void addDepartment_thenReturnDepartment(){
        Optional<Department> department = departmentRepository.findById(1l);

        assertTrue(department.isPresent());
        Department d  = department.get();

        assertEquals(d.getDepartmentName(),"ME");
        assertEquals(d.getDepartmentCode(),"ME - 011");


    }

}