package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
