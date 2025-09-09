package com.springbootpractice.firstspringboot.services;

import java.util.List;

import com.springbootpractice.firstspringboot.models.Student;

public interface StudentService {
	Student saveStudent(Student student);
    List<Student> getAllStudents();
   
}
