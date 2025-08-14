package com.springbootpractice.firstspringboot;

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

@RestController
@RequestMapping("/apiadd")
public class AdditionController {
@GetMapping
public String TestGetMapping()
{
	return "Http GetMapping";
}
@PostMapping
public AdditionResponse AddMethod(@RequestBody AdditionRequest obj)
{
	 AdditionResponse obj1 = new AdditionResponse();
	 int result = obj.getNum1()+obj.getNum2();
	 obj1.setResult(result);
	 return obj1;
}

@PutMapping("/puturl")
public String TestPutMapping()
{
	return "Http PutMapping";
}

@DeleteMapping
public String TestDeleteMapping()
{
	return "Http DeleteMapping";
}
@PatchMapping
public String TestPatchMapping()
{
	return "Http PatchMapping";
}
}
