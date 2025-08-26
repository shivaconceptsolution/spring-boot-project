package com.springbootpractice.firstspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.firstspringboot.models.Reg;
import com.springbootpractice.firstspringboot.services.RegService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import java.util.*;;
@RestController
@RequestMapping("/api")
public class RegController {

@Autowired
private RegService regService;

@Value("${app.security.username}")
private String ymlUsername;

@Value("${app.security.password}")
private String ymlPassword;
@PostMapping("/reg")
public Reg AddRegistration(@RequestBody Reg obj)
{
	return regService.saveReg(obj);
}
@PostMapping("/login")
public ResponseEntity<Map<String, Object>> LoginOperation(@RequestBody Reg obj)
{
	Map<String, Object> response = new HashMap<>();
	if(regService.verifyReg(obj))
	{
		 response.put("status", "success");
         response.put("message", "Login successful");
         response.put("username", ymlUsername);
         response.put("username", ymlPassword);
	}
	else
	{
		response.put("status", "fail");
        response.put("message", "Invalid username or password");
	}
	return ResponseEntity.ok(response);
}
}
