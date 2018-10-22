package com.library.controller;

import com.library.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class MenuController {

    @RequestMapping("/menu")
    private String mainMenu(){

        return "main-menu";
    }

    @RequestMapping("/postRegister")
    private String postRegister(@ModelAttribute("user") User theUser){
        System.out.println("username: " + theUser.getUsername());

        return "post-register";
    }


}
