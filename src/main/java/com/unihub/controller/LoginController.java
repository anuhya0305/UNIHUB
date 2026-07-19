package com.unihub.controller;

import com.unihub.entity.User;
import com.unihub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public ModelAndView loginPage() {

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(User user) {
        User validUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (validUser != null) {
            return new ModelAndView("redirect:/dashboard");
        }
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        mav.addObject("error", "Invalid Email or Password");
        return mav;
    }
}