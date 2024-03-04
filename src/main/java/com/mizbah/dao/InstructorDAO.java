package com.mizbah.dao;

import com.mizbah.entity.Instructor;

public interface InstructorDAO {

	void save(Instructor instructor);

	Instructor findById(int id);
}
