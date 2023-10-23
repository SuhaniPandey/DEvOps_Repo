package com.example.devops_assignment1.controller;

import com.example.devops_assignment1.model.Department;
import com.example.devops_assignment1.model.Story;
import com.example.devops_assignment1.service.DepartmentService;
import com.example.devops_assignment1.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/department/")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("")
    public ResponseEntity<String> displaysth() {

        return new ResponseEntity<>("Hello , this is someone",HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createDepartment(@RequestBody Department department) {

        try {
            Department storyCreated = departmentService.Create(department);
            return new ResponseEntity<>(storyCreated, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Object> getStoryById(@PathVariable Long id) {

        Optional<Department> findDepartmentById = departmentService.findById(id);
        if (findDepartmentById.isPresent()) {
            return new ResponseEntity<Object>(findDepartmentById.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try {
            departmentService.DeleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
