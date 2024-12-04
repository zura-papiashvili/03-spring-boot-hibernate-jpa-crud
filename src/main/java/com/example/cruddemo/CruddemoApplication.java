package com.example.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// findStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);
		};

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Deleting student: " + myStudent);
		studentDAO.deleteById(studentId);

		System.out.println("Deleted student: " + myStudent);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student: " + myStudent);
		myStudent.setFirstName("John");

		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// display the students
		System.out.println("Displaying the students by last name");
		studentDAO.findByLastName("Doe").forEach(System.out::println);

	}

	private void queryForStudents(StudentDAO studentDAO) {
		// display the students
		System.out.println("Displaying the students");
		studentDAO.findAll().forEach(System.out::println);

	}

	private void findStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Creating a new student");
		Student tempStudent = new Student("Paul", "Wall", "pw@gmail.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display the student
		System.out.println("Saved student: " + tempStudent.getId());

		// find the student
		System.out.println("Finding the student");
		Student myStudent = studentDAO.findById(tempStudent.getId());

		// display the student
		System.out.println("Found student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create students
		System.out.println("Creating multiple students");
		Student tempStudent1 = new Student("John", "Doe", "John.doe.@gmail.com");
		Student tempStudent2 = new Student("Mary", "Public", "Mary.public.@gmail.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "Bonita.applebum.@gmail.com");

		// save the students

		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// display the students
		System.out.println("Saved students: " + tempStudent1.getId() + " " + tempStudent2.getId() + " "
				+ tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Creating a new student");
		Student tempStudent = new Student("John", "Doe", "john.doe@gmail.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display the student
		System.out.println("Saved student: " + tempStudent.getId());

	}

}
