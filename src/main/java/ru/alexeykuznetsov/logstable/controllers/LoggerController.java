package ru.alexeykuznetsov.logstable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import ru.alexeykuznetsov.logstable.entity.Logger;
import ru.alexeykuznetsov.logstable.service.LoggerService;

import java.util.List;


@RestController
@RequestMapping("/logs-table")
public class LoggerController {
    @Autowired
    LoggerService loggerService;

    @PostMapping("/logs")
    public ResponseEntity<String> createLog(@RequestBody Logger log) {
        loggerService.createOrUpdateLog(log);
        return ResponseEntity.ok("Log created");
    }

    @GetMapping("/logs/{id}")
    public List<Logger> getStudentLog(@PathVariable int id) {
        List<Logger> logs = loggerService.getStudentLog(id);
        return logs;
    }

    @DeleteMapping("/logs/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        loggerService.deleteLog(id);
        return ResponseEntity.ok("Log removed");
    }
}
