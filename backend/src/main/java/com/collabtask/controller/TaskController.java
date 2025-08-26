package com.collabtask.controller;

import com.collabtask.model.Task;
import com.collabtask.model.TaskStatus;
import com.collabtask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        if (task.getTitle() == null || task.getTeam() == null) {
            return ResponseEntity.badRequest().body("Task title and team are required");
        }
        try {
            Task created = taskService.createTask(task);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating task: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task task) {
        try {
            Task updated = taskService.updateTask(id, task);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Task not found or error updating task: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Task not found: " + e.getMessage());
        }
    }

    @GetMapping("/assignee/{userId}")
    public List<Task> getTasksByAssignee(@PathVariable Long userId) {
        return taskService.getTasksByAssignee(userId);
    }

    @GetMapping("/team/{teamId}")
    public List<Task> getTasksByTeam(@PathVariable Long teamId) {
        return taskService.getTasksByTeam(teamId);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    // Analytics endpoints
    @GetMapping("/analytics/completed/user/{userId}")
    public long countCompletedTasksByUser(@PathVariable Long userId) {
        return taskService.countCompletedTasksByUser(userId);
    }

    @GetMapping("/analytics/completed/team/{teamId}")
    public long countCompletedTasksByTeam(@PathVariable Long teamId) {
        return taskService.countCompletedTasksByTeam(teamId);
    }
}
