package com.springbootpractice.firstspringboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootpractice.firstspringboot.models.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {

}
