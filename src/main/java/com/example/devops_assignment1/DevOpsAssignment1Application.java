package com.example.devops_assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com.example.devops_assignment1.repository")
public class DevOpsAssignment1Application {

    @RequestMapping("/")
    public String index() {
        return "<body><h1>DevOps and Cloud</h1> " +
                "<h2>Dockerizing Spring Boot Backend Application (exercise 7).</h2>" +
                "<p>With Docker, we can containerize SEP4 back-end and front-end applications.</p></body>";
    }
    public static void main(String[] args) {
        SpringApplication.run(DevOpsAssignment1Application.class, args);
    }

}
