package ru.alexeykuznetsov.logstable.repository;

import ru.alexeykuznetsov.logstable.entity.Logger;

import java.util.List;

public interface LoggerRepository {
    void createOrUpdateLog(Logger log);

    void deleteLog(int id);

    List<Logger> getStudentLog(int id);
}
