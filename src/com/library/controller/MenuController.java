package com.library.controller;

import com.library.entity.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/library")
public class MenuController {

    @Autowired
    private UserService userService;

    @RequestMapping("/menu")
    private String mainMenu(){

        return "main-menu";
    }


}
