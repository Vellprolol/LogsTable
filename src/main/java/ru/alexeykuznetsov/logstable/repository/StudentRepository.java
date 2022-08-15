package ru.alexeykuznetsov.logstable.repository;

import ru.alexeykuznetsov.logstable.entity.Student;

import java.util.List;

public interface StudentRepository {
    void addStudent(Student student);

    void deleteStudent(int id);

    List<Student> getAllStudents();
}
