package com.example.devops_assignment1.service;

import com.example.devops_assignment1.model.Department;
import com.example.devops_assignment1.repository.IDepartmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DepartmentServiceTest {

    @Mock
    private IDepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void testCreate() {
        Department departmentToCreate = new Department();
        departmentToCreate.setName("Test Department");

        Department createdDepartment = new Department();
        createdDepartment.setId(1L);
        createdDepartment.setName("Test Department");

        when(departmentRepository.save(any(Department.class))).thenReturn(createdDepartment);

        Department result = departmentService.Create(departmentToCreate);

        assertEquals(createdDepartment, result);
        verify(departmentRepository, times(1)).save(any(Department.class));
    }

    @Test
    public void testFindById_Success() {
        Long departmentId = 1L;

        Department existingDepartment = new Department();
        existingDepartment.setId(departmentId);
        existingDepartment.setName("Existing Department");

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(existingDepartment));

        Optional<Department> result = departmentService.findById(departmentId);

        assertEquals(existingDepartment, result.orElse(null));
        verify(departmentRepository, times(1)).findById(departmentId);
    }

    @Test
    public void testFindById_NotFound() {
        Long departmentId = 1L;

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.empty());

        Optional<Department> result = departmentService.findById(departmentId);

        assertEquals(Optional.empty(), result);
        verify(departmentRepository, times(1)).findById(departmentId);
    }

    @Test
    public void testDeleteById_Success() {
        Long departmentId = 1L;

        Department existingDepartment = new Department();
        existingDepartment.setId(departmentId);
        existingDepartment.setName("Existing Department");

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(existingDepartment));

        departmentService.DeleteById(departmentId);

        verify(departmentRepository, times(1)).findById(departmentId);
        verify(departmentRepository, times(1)).delete(existingDepartment);
    }


}
