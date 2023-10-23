package com.example.devops_assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("") // Define a base path for the entire controller
public class DevOpsAssignment1Application {

    @RequestMapping("/") // Maps to the root URL: /app/
    public String index() {
        return "<body><h1> Containerization and orchestration doka </h1>" +
                "<p>Hello, I am doka teacher who works on my computa.</p></body>";
    }

    @RequestMapping("/error") // Maps to /app/hello
    public String hello() {
        return "Hello from /app/hello!";
    }

    @RequestMapping("/other") // Maps to /app/other
    public String other() {
        return "This is another endpoint under /app/other.";
    }

    public static void main(String[] args) {
        SpringApplication.run(DevOpsAssignment1Application.class, args);
    }
}
