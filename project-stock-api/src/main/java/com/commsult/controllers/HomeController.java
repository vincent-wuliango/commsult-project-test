package com.commsult.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/api/home")
    public String home() {
        return "Hello, the time at the server is now " + new Date() + "\n";
    }
}
