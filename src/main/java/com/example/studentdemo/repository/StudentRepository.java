package com.example.studentdemo.repository;

import com.example.studentdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student,Long> {

    Optional<Student> findStudentByEmail(String email);


}
