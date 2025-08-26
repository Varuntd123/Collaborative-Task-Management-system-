package com.collabtask.service;

import com.collabtask.model.*;
import com.collabtask.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    private final ReentrantLock lock = new ReentrantLock();

    // Round-robin assignment helper
    private int roundRobinIndex = 0;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Transactional
    public Task createTask(Task task) {
        if (task.getAssignee() == null && task.getTeam() != null) {
            Team team = teamRepository.findById(task.getTeam().getId()).orElseThrow();
            List<User> members = team.getMembers().stream().filter(u -> u.getRole() == Role.MEMBER).toList();
            if (!members.isEmpty()) {
                roundRobinIndex = roundRobinIndex % members.size();
                task.setAssignee(members.get(roundRobinIndex));
                roundRobinIndex++;
            }
        }
        task.setStatus(TaskStatus.PENDING);
        task.setCreatedAt(LocalDateTime.now());
        System.out.println("[NOTIFY] Task assigned to: " + (task.getAssignee() != null ? task.getAssignee().getUsername() : "None"));
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        if (task.getStatus() == TaskStatus.COMPLETED) {
            throw new IllegalStateException("Cannot delete completed task");
        }
        taskRepository.deleteById(id);
    }

    @Transactional
    public Task updateTask(Long id, Task taskDetails) {
        lock.lock();
        try {
            Task task = taskRepository.findById(id).orElseThrow();
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            task.setAssignee(taskDetails.getAssignee());
            task.setDueDate(taskDetails.getDueDate());
            task.setUpdatedAt(LocalDateTime.now());
            System.out.println("[NOTIFY] Task updated: " + task.getTitle());
            return taskRepository.save(task);
        } finally {
            lock.unlock();
        }
    }

    public List<Task> getTasksByAssignee(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return taskRepository.findByAssignee(user);
    }

    public List<Task> getTasksByTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow();
        return taskRepository.findByTeam(team);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    // Analytics: tasks completed per user
    public long countCompletedTasksByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return taskRepository.findByAssignee(user).stream().filter(t -> t.getStatus() == TaskStatus.COMPLETED).count();
    }
    // Analytics: tasks completed per team
    public long countCompletedTasksByTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow();
        return taskRepository.findByTeam(team).stream().filter(t -> t.getStatus() == TaskStatus.COMPLETED).count();
    }
}
