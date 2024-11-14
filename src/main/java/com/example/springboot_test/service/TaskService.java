package com.example.springboot_test.service;

import com.example.springboot_test.model.Task;
import com.example.springboot_test.model.AppUser;
import com.example.springboot_test.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findByUser(AppUser appUser) {
        return taskRepository.findByUser(appUser);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }
}