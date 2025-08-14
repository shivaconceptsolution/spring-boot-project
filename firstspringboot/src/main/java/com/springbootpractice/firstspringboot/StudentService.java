package com.springbootpractice.firstspringboot;

import java.util.List;

public interface StudentService {
	Student saveStudent(Student student);
    List<Student> getAllStudents();
   
}
