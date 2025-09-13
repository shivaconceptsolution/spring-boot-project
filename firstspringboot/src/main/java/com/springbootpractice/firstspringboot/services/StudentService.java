package com.springbootpractice.firstspringboot.services;

import java.util.List;

import com.springbootpractice.firstspringboot.models.Student;

public interface StudentService {
	Student saveStudent(Student student);
	Student updateStudent(Student student);
	void deleteStudent(Long id);
    List<Student> getAllStudents();
	Student getStudentById(Long id);
   
}
