package ru.alexeykuznetsov.logstable.service;

import ru.alexeykuznetsov.logstable.entity.Logger;

import java.util.List;

public interface LoggerService {
    void createOrUpdateLog(Logger log);

    List<Logger> getStudentLog(int id);
}
