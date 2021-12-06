package com.example.studentdemo.controller;

import com.example.studentdemo.model.Student;
import com.example.studentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getStudents(){
       return  service.getStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student){
        service.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        service.deleteStudentById(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student student){
        service.updateStudentById(studentId, student);
    }
}
