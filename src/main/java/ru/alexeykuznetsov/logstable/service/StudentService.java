package ru.alexeykuznetsov.logstable.service;

import ru.alexeykuznetsov.logstable.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    void deleteStudent(int id);

    List<Student> getAllStudents();
}
