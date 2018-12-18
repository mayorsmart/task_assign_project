package com.task.controller;

import com.task.entities.Task;
import com.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/addTask")
    public String taskForm(String email, Model model, HttpSession session){
        session.setAttribute("email", email);
        model.addAttribute("task",new Task());
        return "views/taskForm";
    }

}
