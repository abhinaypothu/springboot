package com.pothu.springbootpractice.repository;

import com.pothu.springbootpractice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    /*
    syntax for find by column name is
    public Department findByColumnName(String columnName);
     */

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
