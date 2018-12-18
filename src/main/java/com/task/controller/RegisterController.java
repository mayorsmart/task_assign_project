package com.task.controller;

import com.task.entities.User;
import com.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
  private  UserService userService;

        //add/register new user
    @GetMapping(name = "/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "views/registerForm";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if (userService.isUserPresent(user.getEmail())){
            model.addAttribute("exit", true);

            return "views/registerForm";
        }

        userService.createUser(user);
        return "views/success";
    }

}