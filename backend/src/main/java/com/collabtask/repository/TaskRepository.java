package com.collabtask.repository;

import com.collabtask.model.Task;
import com.collabtask.model.Team;
import com.collabtask.model.User;
import com.collabtask.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignee(User assignee);
    List<Task> findByTeam(Team team);
    List<Task> findByStatus(TaskStatus status);
}
