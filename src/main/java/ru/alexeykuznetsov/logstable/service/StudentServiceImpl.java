package ru.alexeykuznetsov.logstable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexeykuznetsov.logstable.entity.Student;
import ru.alexeykuznetsov.logstable.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Override
    @Transactional
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
