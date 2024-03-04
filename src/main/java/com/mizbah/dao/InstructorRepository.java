package com.mizbah.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mizbah.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	@Query("SELECT i FROM Instructor i JOIN FETCH i.courses courses")
	List<Instructor> retrieveAllWithCourses();

	@Query("SELECT i FROM Instructor i JOIN FETCH i.courses courses JOIN FETCH i.instructorDetail instructorDetail")
	List<Instructor> retrieveAllWithCoursesAndDetails();

	@Query("SELECT i FROM Instructor i JOIN FETCH i.instructorDetail instructorDetail")
	List<Instructor> findAll();

	@Query("SELECT i FROM Instructor i JOIN FETCH i.courses courses WHERE i.id = :id")
	Instructor retrieveByIdWithCourses(int id);
}
