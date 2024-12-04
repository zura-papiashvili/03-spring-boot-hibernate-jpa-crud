package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define the fields for entity manager

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int theId) {
        return entityManager.find(Student.class, theId);
    }

    @Override
    public List<Student> findAll() {
        // create a query
        List<Student> students = entityManager.createQuery("from Student order by lastName", Student.class)
                .getResultList();

        // return the results

        return students;
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create a query
        List<Student> students = entityManager.createQuery("from Student where lastName=:lastName", Student.class)
                .setParameter("lastName", theLastName).getResultList();

        // return the results
        return students;
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        // retrive the student
        Student theStudent = entityManager.find(Student.class, theId);

        // delete the student
        entityManager.remove(theStudent);
    }

}
