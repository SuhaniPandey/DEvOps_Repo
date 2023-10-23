package com.example.devops_assignment1.controller;


import com.example.devops_assignment1.model.Story;
import com.example.devops_assignment1.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/story/")
public class StoryController {

    private StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping()
    public ResponseEntity<Object> createStory(@RequestBody Story story) {

        try {
            Story storyCreated = storyService.Create(story);
            return new ResponseEntity<>(storyCreated, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Object> getStoryById(@PathVariable Long id) {

        Optional<Story> findStoryById = storyService.findById(id);
        if (findStoryById.isPresent()) {
            return new ResponseEntity<Object>(findStoryById.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try {
            storyService.DeleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
