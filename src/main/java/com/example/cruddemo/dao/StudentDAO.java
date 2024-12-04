package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    // find all students by last name
    List<Student> findByLastName(String lastName);

    // update a student
    void update(Student student);

    // delete a student
    void deleteById(int id);

}
