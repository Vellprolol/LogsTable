package ru.alexeykuznetsov.logstable.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.alexeykuznetsov.logstable.entity.Logger;
import ru.alexeykuznetsov.logstable.entity.Student;
import ru.alexeykuznetsov.logstable.exceprtion.StudentNotFoundException;

import java.util.List;

@Repository
public class LoggerRepositoryImpl implements LoggerRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrUpdateLog(Logger log) {
        Session session = sessionFactory.getCurrentSession();
        if (!isStudentExist(log.getStudentId())) {
            throw new StudentNotFoundException("There is no student with this id");
        }
        session.saveOrUpdate(log);
    }

    @Override
    public void deleteLog(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Logger> loggerQuery = session.createQuery("delete from Logger where id =:logId");
        loggerQuery.setParameter("logId", id);
        loggerQuery.executeUpdate();
    }

    @Override
    public List<Logger> getStudentLog(int id) {
        if (!isStudentExist(id)) {
            throw new StudentNotFoundException("There is no student with this id");
        }
        Session session = sessionFactory.getCurrentSession();
        Query<Logger> query = session.createQuery("from Logger where studentId =:studentNumber");
        query.setParameter("studentNumber", id);
        List<Logger> logsList = query.getResultList();
        return logsList;
    }

    private boolean isStudentExist(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        if (student == null) {
            return false;
        }
        return true;
    }

}
