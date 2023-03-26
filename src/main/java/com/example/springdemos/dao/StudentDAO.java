package com.example.springdemos.dao;

import com.example.springdemos.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    void saveList(List<Student> studentList);

    Student findById(Long id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Long id);

    Integer deleteAll();

}
