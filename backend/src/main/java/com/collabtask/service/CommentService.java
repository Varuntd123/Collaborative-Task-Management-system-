package com.collabtask.service;

import com.collabtask.model.Comment;
import com.collabtask.model.Task;
import com.collabtask.repository.CommentRepository;
import com.collabtask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TaskRepository taskRepository;

    public List<Comment> getCommentsByTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        return commentRepository.findByTask(task);
    }

    public Comment addComment(Long taskId, Comment comment) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        comment.setTask(task);
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}
