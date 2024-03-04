package com.mizbah.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mizbah.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
