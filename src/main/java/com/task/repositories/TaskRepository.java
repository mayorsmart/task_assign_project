package com.task.repositories;

import com.task.entities.Task;
import com.task.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task , Long> {
    List<Task> findByUser(User user);
}
