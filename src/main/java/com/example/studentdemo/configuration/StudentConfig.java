package com.example.studentdemo.configuration;

import com.example.studentdemo.model.Student;
import com.example.studentdemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student mavin = new Student("mavin","mavinsao@gmail", LocalDate.of(1999, Month.JANUARY, 11));
            Student thida = new Student("thida","thida@gmail", LocalDate.of(1998, Month.JANUARY, 11));
            studentRepository.saveAll(
                    List.of(mavin,thida)
            );

        };
    }


}
