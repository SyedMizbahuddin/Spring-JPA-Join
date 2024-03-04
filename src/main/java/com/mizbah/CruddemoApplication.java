package com.mizbah;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mizbah.dao.CourseRepository;
import com.mizbah.dao.InstructorDAO;
import com.mizbah.dao.InstructorDetailRepository;
import com.mizbah.dao.InstructorRepository;
import com.mizbah.dao.StudentRepository;
import com.mizbah.entity.Course;
import com.mizbah.entity.Instructor;
import com.mizbah.entity.InstructorDetail;
import com.mizbah.entity.Review;
import com.mizbah.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(InstructorDAO instructorDAO, InstructorRepository instructorRepository,
			InstructorDetailRepository instructorDetailRepository, CourseRepository courseRepository,
			StudentRepository studentRepository) {
		return runner -> {

//			createInstructor(instructorDAO);

//			createMultipleInstructor(instructorDAO);

			createCourseStudent(courseRepository, studentRepository);

//			findById(instructorDAO, 1);

//			deleteById(instructorRepository, 1);

//			deleteCourseById(courseRepository, 12);

//			update(instructorRepository, 1);

//			findById(instructorRepository, 1, courseRepository);

//			findAll(instructorRepository);
//
//			findById(instructorDetailRepository, 1);

//			deleteById(instructorDetailRepository, 1);

//			findCourseReview(courseRepository, 10);

//			deleteById(courseRepository, 10);
		};

	}

	private void createCourseStudent(CourseRepository courseRepository, StudentRepository studentRepository) {
		Course course1 = new Course("Science");
		Course course2 = new Course("Math");
		Course course3 = new Course("Physics");
		Course course4 = new Course("Chemistry");

		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);

		Student student1 = new Student("sai", "supree", "supree@ok.com");
		Student student2 = new Student("dany", "kani", "kani.com");

		studentRepository.save(student1);
		studentRepository.save(student2);
	}

	private void deleteById(CourseRepository courseRepository, int id) {
		courseRepository.deleteById(id);

	}

	private void findCourseReview(CourseRepository courseRepository, int i) {
		Course c = courseRepository.findById(i);

		System.out.println(c.getReviews().size());

	}

	private void deleteCourseById(CourseRepository courseRepository, int id) {
		courseRepository.deleteById(id);

	}

	private void update(InstructorRepository instructorRepository, int id) {
		Instructor ins = instructorRepository.findById(id).get();
		ins.setFirstName("changed");
		instructorRepository.save(ins);

	}

	private void findAll(InstructorRepository instructorRepository) {
		List<Instructor> list = instructorRepository.retrieveAllWithCourses();
		System.out.println();
		print(list);

	}

	void print(List<Instructor> list) {
		for (Instructor curr : list) {
			System.out.println(curr.getFirstName());
			System.out.println(curr.getInstructorDetail().getHobby());
			System.out.println(curr.getCourses().size());
			System.out.println();
		}
	}

	private void deleteById(InstructorDetailRepository instructorDetailRepository, int id) {
		instructorDetailRepository.deleteById(id);

	}

	private void findById(InstructorDetailRepository instructorDetailRepository, int id) {
		InstructorDetail obj = instructorDetailRepository.findById(id).get();
		System.out.println(obj.getYoutubeChannel() + " " + obj.getInstructor().getFirstName());

	}

	private void deleteById(InstructorRepository instructorRepository, int id) {
		Instructor ins = instructorRepository.retrieveByIdWithCourses(id);

		for (Course c : ins.getCourses()) {
			c.setInstructor(null);
		}
		instructorRepository.delete(ins);

	}

	private void findById(InstructorRepository instructorRepository, int id, CourseRepository courseRepository) {
		Instructor instructor = instructorRepository.findById(id).get();
		System.out.println(instructor.getFirstName() + " " + instructor.getInstructorDetail().getHobby() + " ");

		List<Course> courses = courseRepository.findByInstructorId(3);
		instructor.setCourses(courses);
		System.out.println(instructor.getCourses().size());
	}

	private void findById(InstructorDAO instructorDAO, int id) {
		System.out.println(instructorDAO.findById(id));
	}

	private void createMultipleInstructor(InstructorDAO instructorDAO) {

		Review review1 = new Review("ok");
		Review review2 = new Review("nice");
		Review review3 = new Review("great");
		Review review4 = new Review("hmm");

		Course course1 = new Course("Science");
		course1.add(review1);
		course1.add(review2);
		Course course2 = new Course("Math");
		course2.add(review3);
		Course course3 = new Course("Physics");
		course3.add(review4);
		Course course4 = new Course("Chemistry");

		InstructorDetail instructorDetail = new InstructorDetail("find it", "playing");
		Instructor instructor = new Instructor("chad", "darby", "ok@ok.com", instructorDetail);
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructorDAO.save(instructor);

		InstructorDetail instructorDetail2 = new InstructorDetail("search ", "running");
		Instructor instructor2 = new Instructor("raja", "raghu", "hmm@ok.com", instructorDetail2);
		instructor2.addCourse(course3);
		instructorDAO.save(instructor2);

		InstructorDetail instructorDetail3 = new InstructorDetail("draw ", "walking");
		Instructor instructor3 = new Instructor("skoin", "skety", "ardy@ok.com", instructorDetail3);
		instructor3.addCourse(course4);
		instructorDAO.save(instructor3);

	}

	private void createInstructor(InstructorDAO instructorDAO) {

		InstructorDetail instructorDetail = new InstructorDetail("find it", "playing");
		Instructor instructor = new Instructor("chad", "darby", "ok@ok.com", instructorDetail);
		instructorDAO.save(instructor);
	}

}
