package com.springbootpractice.firstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
	    "com.springbootpractice.model",
	    "com.springbootpractice.firstspringboot"
	    
	})
public class App {
    public static void main(String[] args) {
    	SpringApplication.run(App.class,args);	
    }
}
