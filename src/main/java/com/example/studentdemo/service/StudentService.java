package com.example.studentdemo.service;

import com.example.studentdemo.model.Student;
import com.example.studentdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudentById(Long studentId){
        System.out.println(studentId);
        Boolean exist = studentRepository.existsById(studentId);

        if (!exist) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudentById(Long studentId, Student student){
        Student existStudent = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student with " + studentId + " does not exist"
        ));

        if (student.getName() != null && student.getName().length() > 0 && !Objects.equals(existStudent.getName(), student.getName())){
            existStudent.setName(student.getName());
        }
        if (student.getEmail() != null && student.getEmail().length() > 0 && !Objects.equals(existStudent.getEmail(), student.getEmail())){
            existStudent.setEmail(student.getEmail());
        }

    }

}
