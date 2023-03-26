package com.example.springdemos;

import com.example.springdemos.dao.StudentDAO;
import com.example.springdemos.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringdemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemosApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createMultipleStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        // Delete the Student
        Long studentId = 3L;

        System.out.println("Deleting student id: " + studentId);

        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // Retrieve student based on the id: primary key
        long studentId = 1L;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // Change first name to "Scooby"
        myStudent.setFirstName("Scooby");

        // Update the student
        studentDAO.update(myStudent);

        System.out.println("----------");
        // Display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // Get a List of Students
        List<Student> theStudents = studentDAO.findByLastName("Doe");

        // Display list of Students
        for (Student student: theStudents) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // Get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // Display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // Create a Student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@yahoo.com");

        // save the student
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        long theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found my student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // Create multiple students
        System.out.println("Creating 3 student object ...");
        Student tempStudent1 = new Student("Paul", "Doe", "paul@hotmail.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "Bonita@roblox.com");

        // save the student objects
        System.out.println("Saving the students");
        studentDAO.saveList(List.of(tempStudent1, tempStudent2, tempStudent3));
    }

    private void createStudent(StudentDAO studentDAO) {

        // Create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Doe", "paul@hotmail.com");

        // Save the student object
        System.out.println("Saving the student");
        studentDAO.save(tempStudent);

        // Display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());

    }

}
