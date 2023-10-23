package com.example.devops_assignment1.service;

import com.example.devops_assignment1.model.Department;
import com.example.devops_assignment1.model.Story;
import com.example.devops_assignment1.repository.IDepartmentRepository;
import com.example.devops_assignment1.repository.IStoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoryService {

    IStoryRepository storyRepository;

    public StoryService(IStoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public Story Create(Story story) {

        return storyRepository.save(story);
    }

    public Optional<Story> findById(Long id) {
        return storyRepository.findById(id);
    }

    public Optional<Story> Update(Story department){
        return Optional.empty();
    }

    public void DeleteById(Long id) {
        Optional<Story> id1 = storyRepository.findById(id);
        id1.ifPresent(story -> {
            storyRepository.delete(story);
        });
    }
}
