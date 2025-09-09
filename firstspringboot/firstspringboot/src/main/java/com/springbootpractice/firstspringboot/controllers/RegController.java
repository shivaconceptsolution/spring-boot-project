package com.springbootpractice.firstspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;

import com.springbootpractice.firstspringboot.models.Reg;
import com.springbootpractice.firstspringboot.services.RegService;

import java.util.*;

@RestController
@RequestMapping("/api")
public class RegController {

    @Autowired
    private RegService regService;
    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;
   

    @PostMapping("/reg")
    public Reg addRegistration(@RequestBody Reg obj) {
        return regService.saveReg(obj);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginOperation(@RequestBody Reg obj) {
        Map<String, Object> response = new HashMap<>();

       
        if (regService.verifyReg(obj)) {
            response.put("status", "success");
            response.put("message", "Login successful");
            response.put("username",username);
            response.put("password",password); // fixed key
        } else {
            response.put("status", "fail");
            response.put("message", "Invalid username or password");
        }

        return ResponseEntity.ok(response);
    }
}
