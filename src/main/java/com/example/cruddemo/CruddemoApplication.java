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
		};

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
