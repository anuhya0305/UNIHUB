package com.unihub.controller;

import com.unihub.entity.User;
import com.unihub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView registerPage() {

        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());

        return mav;
    }

    @PostMapping("/register")
    public String registerUser(User user) {

        user.setRole("STUDENT");

        userService.registerUser(user);

        return "redirect:/login";
    }

}