package com.collabtask.controller;

import com.collabtask.model.Comment;
import com.collabtask.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/task/{taskId}")
    public List<Comment> getCommentsByTask(@PathVariable Long taskId) {
        return commentService.getCommentsByTask(taskId);
    }

    @PostMapping("/task/{taskId}")
    public ResponseEntity<?> addComment(@PathVariable Long taskId, @RequestBody Comment comment) {
        if (comment.getContent() == null || comment.getContent().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Comment content is required");
        }
        try {
            Comment created = commentService.addComment(taskId, comment);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding comment: " + e.getMessage());
        }
    }
}
