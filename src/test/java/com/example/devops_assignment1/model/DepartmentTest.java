package com.example.devops_assignment1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentTest {

    private Long departmentId;
    private String departmentName;
    private Department testDepartment;

    @BeforeEach
    public void setUp(){
        departmentId = 1L;
        departmentName = "Software";
        testDepartment= new Department(departmentId,departmentName);
    }

    @Test
    public void ctorTest(){
        assertEquals(testDepartment.getId(), departmentId);
        assertEquals(testDepartment.getName(), departmentName);
    }

    @Test
    public void setNewDepartmentId_success_Scenario(){
        testDepartment.setId(2L);
        assertEquals(2L,testDepartment.getId());
    }

    @Test
    public void setNewDepartmentName_success_Scenario(){
        testDepartment.setName("Architect");
        assertEquals("Architect",testDepartment.getName());
    }




}
