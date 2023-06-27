package com.group.Demo.service;

import com.group.Demo.models.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    public Student saveStudent(Student student);
}
