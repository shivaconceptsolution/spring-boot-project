package com.springbootpractice.firstspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootpractice.firstspringboot.models.Student;
import com.springbootpractice.firstspringboot.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
    private StudentRepository studentRepo;
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		 return studentRepo.findAll();
	}

	

}
