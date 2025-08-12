package com.springbootpractice.firstspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springbootpractice.model.*;
import java.util.*;
@RestController
@RequestMapping("api/student")
public class StudentController {
	 @GetMapping
     public List<Student> GetStudentInfo()
     {
			List<Student> obj = new ArrayList<Student>();
			obj.add(new Student(1001,"Stu1","CS",45000));
			obj.add(new Student(1002,"Stu1","CS",45000));
			obj.add(new Student(1003,"Stu3","CS",45000));
			obj.add(new Student(1004,"Stu4","IT",65000));
			return obj;
    	 
     }

}
