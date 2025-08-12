package com.springbootpractice.firstspringboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.model.AdditionRequest;
import com.springbootpractice.model.AdditionResponse;

@RestController
@RequestMapping("/apiadd")
public class AdditionController {
	
@PostMapping(value = "/addition", produces = "application/json")	
public AdditionResponse AddMethod(@RequestBody AdditionRequest request)
{
	 AdditionResponse response = new AdditionResponse();
	 int result = request.getNum1()+request.getNum2();
	 response.setResult(result);
	 return response;
}
}
