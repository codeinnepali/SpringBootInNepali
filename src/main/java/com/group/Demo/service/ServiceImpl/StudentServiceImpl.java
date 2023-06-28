package com.group.Demo.service.ServiceImpl;

import com.group.Demo.models.Student;
import com.group.Demo.repositories.StudentRepository;
import com.group.Demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
  private   StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
       return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Student student=studentRepository.findById(id).orElse(null);
        return  student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
       Student _student=studentRepository.findById(id).orElse(null);
       if(student!=null){
           _student.setBook(student.getBook());
           _student.setName(student.getName());
           _student.setRoll(student.getRoll());
           studentRepository.save(_student);
           return student;
       }else{
           return  null;
       }
    }

    @Override
    public void deleteStudentById(Long id) {
          studentRepository.deleteById(id);
    }
}
