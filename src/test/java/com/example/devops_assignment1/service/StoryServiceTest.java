package com.example.devops_assignment1.service;

import com.example.devops_assignment1.model.Story;
import com.example.devops_assignment1.repository.IStoryRepository;
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
public class StoryServiceTest {

    @Mock
    private IStoryRepository storyRepository;

    @InjectMocks
    private StoryService storyService;

    @Test
    public void testCreate() {
        Story storyToCreate = new Story();
        storyToCreate.setTitle("Test Story");

        Story createdStory = new Story();
        createdStory.setId(1L);
        createdStory.setTitle("Test Story");

        when(storyRepository.save(any(Story.class))).thenReturn(createdStory);

        Story result = storyService.Create(storyToCreate);

        assertEquals(createdStory, result);
        verify(storyRepository, times(1)).save(any(Story.class));
    }

    @Test
    public void testFindById_Success() {
        Long storyId = 1L;

        Story existingStory = new Story();
        existingStory.setId(storyId);
        existingStory.setTitle("Existing Story");

        when(storyRepository.findById(storyId)).thenReturn(Optional.of(existingStory));

        Optional<Story> result = storyService.findById(storyId);

        assertEquals(existingStory, result.orElse(null));
        verify(storyRepository, times(1)).findById(storyId);
    }

    @Test
    public void testFindById_NotFound() {
        Long storyId = 1L;

        when(storyRepository.findById(storyId)).thenReturn(Optional.empty());

        Optional<Story> result = storyService.findById(storyId);

        assertEquals(Optional.empty(), result);
        verify(storyRepository, times(1)).findById(storyId);
    }

    @Test
    public void testDeleteById_Success() {
        Long storyId = 1L;

        Story existingStory = new Story();
        existingStory.setId(storyId);
        existingStory.setTitle("Existing Story");

        when(storyRepository.findById(storyId)).thenReturn(Optional.of(existingStory));

        storyService.DeleteById(storyId);

        verify(storyRepository, times(1)).findById(storyId);
        verify(storyRepository, times(1)).delete(existingStory);
    }

}
