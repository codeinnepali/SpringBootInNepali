package com.group.Demo.controllers;

import com.group.Demo.models.Student;
import com.group.Demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public Student saveStudent(@RequestBody Student student){
      Student _student=  studentService.saveStudent(student);
        return _student;
    }

    @GetMapping("/all-students")
    public List<Student> getAllStudents(){
        return  studentService.getAllStudent();
    }

    @GetMapping("/get-student-by-id/{id}")
    public Student getStudentById(@PathVariable Long id){
        return  studentService.getStudentById(id);
    }

    @PutMapping("/update-student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete-student-by-id/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);

    }
}

