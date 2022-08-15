package ru.alexeykuznetsov.logstable.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "logs")
public class Logger {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "log")
    private String log;
    @Column(name = "date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    public Logger() {
    }

    public Logger(int studentId, String log, LocalDate date) {
        this.studentId = studentId;
        this.log = log;
        this.date = date;
    }


    public Logger(int id, int studentId, String log, LocalDate date) {
        this.id = id;
        this.studentId = studentId;
        this.log = log;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Logger)) return false;
        Logger logger = (Logger) o;
        return getId() == logger.getId() && getStudentId() == logger.getStudentId() && Objects.equals(getLog(), logger.getLog());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStudentId(), getLog());
    }

    @Override
    public String toString() {
        return "Logger{" +
                "log='" + log + '\'' +
                ", date=" + date +
                '}';
    }
}
