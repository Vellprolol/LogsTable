package ru.alexeykuznetsov.logstable.exceprtion;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}
