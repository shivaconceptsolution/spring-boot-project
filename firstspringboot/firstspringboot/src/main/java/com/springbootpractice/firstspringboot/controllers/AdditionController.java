package com.springbootpractice.firstspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.model.AdditionRequest;
import com.springbootpractice.model.AdditionResponse;
import java.util.*;
@RestController
public class AdditionController {
@GetMapping("/myusers")
public List<String> getUsers() {
    return List.of("Shiva", "Amit", "Neha", "Rahul");
}

}
