package com.example.devops_assignment1.service;

import com.example.devops_assignment1.model.Department;
import com.example.devops_assignment1.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DepartmentService {

    IDepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department Create(Department department) {

        return departmentRepository.save(department);
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public Optional<Department> Update(Department department){
        return Optional.empty();
    }

    public void DeleteById(Long id) {
        Optional<Department> id1 = departmentRepository.findById(id);
        id1.ifPresent(department -> {
            departmentRepository.delete(department);
        });
    }
}
