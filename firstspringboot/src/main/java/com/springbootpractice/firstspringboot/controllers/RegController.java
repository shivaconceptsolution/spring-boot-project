package com.springbootpractice.firstspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.firstspringboot.models.Reg;
import com.springbootpractice.firstspringboot.services.RegService;

@RestController
@RequestMapping("/api")
public class RegController {
@Autowired
private RegService regService;

@PostMapping("/reg")
public Reg AddRegistration(@RequestBody Reg obj)
{
	return regService.saveReg(obj);
}
@PostMapping("/login")
public String LoginOperation(@RequestBody Reg obj)
{
	
	if(regService.verifyReg(obj))
	{
	      return "login success";
	}
	else
	{
		return "login fail";
	}
}
}
