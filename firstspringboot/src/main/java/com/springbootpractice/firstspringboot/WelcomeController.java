package com.springbootpractice.firstspringboot;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller

public class WelcomeController {
	@RequestMapping("/welcome")
	@ResponseBody
	public String sayWelcome() {
	return "Welcome in Spring Boot Application";
	}
}
