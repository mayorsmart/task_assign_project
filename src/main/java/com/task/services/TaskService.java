package com.task.services;

import com.task.entities.Task;
import com.task.entities.User;
import com.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    @Autowired
     private TaskRepository taskRepository;

    //Add task
    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    // show all task
    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);
    }
}
