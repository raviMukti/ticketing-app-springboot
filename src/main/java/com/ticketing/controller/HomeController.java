package com.ticketing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return ("<h1>Ticketing App</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1>Ticketing App</h1>" +
                "<br>" +
                "<p>You Are in User Page</p>");
    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Ticketing App</h1>" +
                "<br>" +
                "<p>Just Only Admin</p>");
    }
}
