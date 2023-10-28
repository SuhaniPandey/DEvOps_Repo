package com.example.devops_assignment1.repository;

import com.example.devops_assignment1.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department,Long> {
}
