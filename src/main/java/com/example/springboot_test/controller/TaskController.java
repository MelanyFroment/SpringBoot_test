package com.example.springboot_test.controller;

import com.example.springboot_test.model.AppUser;
import com.example.springboot_test.model.Task;
import com.example.springboot_test.service.TaskService;
import com.example.springboot_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    // Create Task
    @PostMapping
    public Task createTask(@RequestBody Task task, @RequestParam String username) {
        AppUser appUser = userService.findByUsername(username); // Fetch user based on username
        task.setUser(appUser); // Assign the user to the task
        return taskService.save(task); // Save and return the task
    }


}
