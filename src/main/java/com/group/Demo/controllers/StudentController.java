package com.group.Demo.controllers;

import com.group.Demo.models.Student;
import com.group.Demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public Student saveStudent(@RequestBody Student student){
      Student _student=  studentService.saveStudent(student);
        return _student;
    }
}
