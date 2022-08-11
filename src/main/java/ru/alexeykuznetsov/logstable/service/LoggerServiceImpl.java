package ru.alexeykuznetsov.logstable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexeykuznetsov.logstable.entity.Logger;
import ru.alexeykuznetsov.logstable.repository.LoggerRepository;

import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    LoggerRepository loggerRepository;

    @Override
    @Transactional
    public void createOrUpdateLog(Logger log) {
        loggerRepository.createOrUpdateLog(log);
    }

    @Override
    @Transactional
    public void deleteLog(int id) {
        loggerRepository.deleteLog(id);
    }


    @Override
    @Transactional
    public List<Logger> getStudentLog(int id) {
        List<Logger> logs = loggerRepository.getStudentLog(id);
        return logs;
    }
}
