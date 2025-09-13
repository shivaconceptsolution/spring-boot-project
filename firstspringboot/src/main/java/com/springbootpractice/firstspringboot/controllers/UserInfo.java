package com.springbootpractice.firstspringboot.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.springbootpractice.firstspringboot.models.Reg;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserInfo {
	@GetMapping("/users")
    public String showUsers(Model model,HttpServletRequest request) {
		
		    RestTemplate restTemplate = new RestTemplate();

		    // Your API URL
		    String apiUrl = "http://localhost:8080/api/students";
            HttpSession sess = request.getSession();
		    // Basic Auth credentials
		 //   String username = "admin";
		   // String password = "admin123";
            String username = sess.getAttribute("ukey").toString();
            String password = sess.getAttribute("upass").toString();
            
		    // Encode username:password as Base64
		    String auth = username + ":" + password;
		    byte[] encodedAuth = java.util.Base64.getEncoder().encode(auth.getBytes());
		    String authHeader = "Basic " + new String(encodedAuth);

		    // Build headers
		    org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		    headers.set("Authorization", authHeader);

		    // Build the request entity with headers
		    org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>(headers);

		    // Call API using exchange (so we can pass headers)
		    org.springframework.http.ResponseEntity<List> response =
		            restTemplate.exchange(apiUrl, org.springframework.http.HttpMethod.GET, entity, List.class);

		    // Extract users
		    List<String> users = response.getBody();

		    model.addAttribute("students", users);
		    return "users"; // users.html under src/main/resources/templates
		}

    
	@GetMapping("/regform")
	public String regForm(Model model)
	{
		model.addAttribute("user",new Reg());
		return "regform";
	}
	
	@PostMapping("/register")
	public String regForm(@ModelAttribute("user") Reg user, Model model)
	{
		 RestTemplate restTemplate = new RestTemplate();
		 String apiUrl = "http://localhost:8080/api/reg";
		 Reg savedUser = restTemplate.postForObject(apiUrl,user, Reg.class);
		// model.addAttribute("message", "User registered successfully!");
		 //model.addAttribute("user",new Reg());
		 return "redirect:/loginform";
	}
	
	@GetMapping("/loginform")
	public String loginForm(Model model)
	{
		model.addAttribute("user",new Reg());
		return "loginform";
	}
	
	@PostMapping("/loginuser")
	public String loginForm(@ModelAttribute("user") Reg user, Model model,HttpServletRequest request)
	{
		 RestTemplate restTemplate = new RestTemplate();
		 String apiUrl = "http://localhost:8080/api/login";
		 ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl,user, Map.class);
		 String status = (String) response.getBody().get("status");
		 String username = (String) response.getBody().get("username");
		 String password = (String) response.getBody().get("password");
		 if(status.equals("success"))
		 {
			 HttpSession session = request.getSession();
			 session.setAttribute("ukey",username);
			 session.setAttribute("upass",password);
			 return "redirect:/users";
		 //model.addAttribute("message", "Login successfully!");
		 
		 }
		 else
		 {
			 model.addAttribute("message", "Login failed");
		 }
		 model.addAttribute("user",new Reg());
		 return "loginform";
	}
}
