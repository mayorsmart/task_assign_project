package com.task.controller;

import com.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // list all users

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("user", userService.findAll());

        return "views/list";
    }

//    // Search users
//    @GetMapping("/users")
//    public String listUsers(Model model, @RequestParam (defaultValue = "") String name){
//        model.addAttribute("user", userService.findByName(name));
//
//        return "views/list";
//    }
}
