package com.home.core.controller;

import com.home.core.model.Student;
import com.home.core.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/coursesStudent")
    public List<Student> getStudentByCourse(@RequestParam   (name = "coursesStudent")
                                                            String coursesStudent){
        return studentRepository.findByCourse(coursesStudent);
    }

    @PostMapping
    public String saveStudent(@RequestBody Student student){
        studentRepository.save(student);
        return  "The Student " + student.getNameStudent() +
                " was a completed saved in the " + student.getCoursesStudent() +
                " course";
    }



}
