package com.springbootpractice.firstspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springbootpractice.firstspringboot.models.Student;
import com.springbootpractice.firstspringboot.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

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
	
	 // READ by ID
    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    // UPDATE
  
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    // DELETE
   
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
        
    }

	

	

}
