package com.mizbah.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mizbah.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public List<Course> findByInstructorId(int id);

	@Query("SELECT c FROM Course c JOIN FETCH c.reviews reviews WHERE c.id=:id")
	public Course findById(int id);

	@Query("SELECT c FROM Course c JOIN FETCH c.students students WHERE c.id=:id")
	public Course findCourseStudents(int id);
}
