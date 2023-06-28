package com.group.Demo.service;

import com.group.Demo.models.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudent();

    public Student getStudentById(Long id);

    public Student updateStudent(Long id, Student student);

    public  void deleteStudentById(Long id);
}
