package com.group.Demo.service.ServiceImpl;

import com.group.Demo.models.Student;
import com.group.Demo.repositories.StudentRepository;
import com.group.Demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
  private   StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }
}