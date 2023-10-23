package com.example.devops_assignment1.model;

public class Story {
    private Long id;
    private String title;
    private String content;
    private Department user;


    public Story(Long id, String title, String content, Department user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Department getUser() {
        return user;
    }

    public void setUser(Department user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
