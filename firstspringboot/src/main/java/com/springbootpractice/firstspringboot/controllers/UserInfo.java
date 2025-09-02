package com.springbootpractice.firstspringboot.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserInfo {
	@GetMapping("/users")
    public String showUsers(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        List<String> users = restTemplate.getForObject("http://localhost:8080/myusers", List.class);

        model.addAttribute("users", users);
        return "users"; // users.html under src/main/resources/templates
    }
}
