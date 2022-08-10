package ru.alexeykuznetsov.logstable.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.alexeykuznetsov.logstable.entity.Student;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> loggerQuery = session.createQuery("delete from Logger where studentId =:studentId");
        Query<Student> studentQuery = session.createQuery("delete from Student where id =:studentId");
        loggerQuery.setParameter("studentId", id);
        studentQuery.setParameter("studentId", id);
        loggerQuery.executeUpdate();
        studentQuery.executeUpdate();
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("from Student", Student.class).getResultList();
        return students;
    }
}
