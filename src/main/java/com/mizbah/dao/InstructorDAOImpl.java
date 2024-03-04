package com.mizbah.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mizbah.entity.Instructor;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class InstructorDAOImpl implements InstructorDAO {

	EntityManager entityManager;

	@Transactional
	@Override
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
	}

	@Override
	public Instructor findById(int id) {
		return entityManager.find(Instructor.class, id);
	}

}
