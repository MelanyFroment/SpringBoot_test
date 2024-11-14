package com.example.springboot_test.repository;

import com.example.springboot_test.model.Task;
import com.example.springboot_test.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(AppUser appUser);
}
