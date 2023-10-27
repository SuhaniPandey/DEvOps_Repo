package com.example.devops_assignment1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoryTest {

    private String storyName;
    private Long storyId;
    private String storyContent;
    private Story testStory;
    private Department user;

    @BeforeEach
    public void setUp(){
        storyId=1L;
        storyName="Slow man";
        storyContent="sth sth";
        testStory= new Story(storyId,storyName,storyContent,user);
    }

    @Test
    public void ctortest(){
        assertEquals(testStory.getId(),storyId);
        assertEquals(testStory.getTitle(),storyName);
        assertEquals(testStory.getContent(),storyContent);
    }

    @Test
    public void setNewStoryId_success_Scenario(){
        testStory.setId(2L);
        assertEquals(2L,testStory.getId());
    }

    @Test
    public void setNewStoryName_success_Scenario(){
        testStory.setTitle("Fast name");
        assertEquals("Fast name",testStory.getTitle());
    }

    @Test
    public void setNewStoryContent_success_Scenario(){
        testStory.setContent("everything");
        assertEquals("everything",testStory.getContent());
    }
}
