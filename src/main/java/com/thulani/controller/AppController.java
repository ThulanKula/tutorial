package com.thulani.controller;

import com.thulani.entity.User;
import com.thulani.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String viewHomePage(){
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")User user){
        userService.saveUser(user);
        return "redirect:/home";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable(name = "userId") String id){
        userService.deleteUser(id);
        return "redirect:/home";
    }
}
