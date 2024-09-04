/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package main;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class MainTest {
 



    private StudentManagement studentManager;

    @BeforeEach
    public void setUp() {
       Main main = new Main();
    }

    // Test 1: TestSaveStudent
    @Test
    public void testSaveStudent() {
        // Arrange
        String studentId = "12345";
        String name = "John Doe";
        int age = 20;
        String email = "johndoe@example.com";
        String course = "Computer Science";

        // Act
        studentManager.saveStudent(studentId, name, age, email, course);

        // Assert
        Student student = studentManager.searchStudent(studentId);
        assertNotNull(student, "Student should not be null.");
        assertEquals(studentId, student.getId());
        assertEquals(name, student.getName());
        assertEquals(age, student.getAge());
        assertEquals(email, student.getEmail());
        assertEquals(course, student.getCourse());
    }

    // Test 2: TestSearchStudent
    @Test
    public void testSearchStudent() {
        // Arrange
        String studentId = "12345";
        studentManager.saveStudent(studentId, "John Doe", 20, "johndoe@example.com", "Computer Science");

        // Act
        Student student = studentManager.searchStudent(studentId);

        // Assert
        assertNotNull(student, "Student should not be null.");
        assertEquals(studentId, student.getId());
        assertEquals("John Doe", student.getName());
        assertEquals(20, student.getAge());
        assertEquals("johndoe@example.com", student.getEmail());
        assertEquals("Computer Science", student.getCourse());
    }

    // Test 3: TestSearchStudent_StudentNotFound
    @Test
    public void testSearchStudent_StudentNotFound() {
        // Act
        Student student = studentManager.searchStudent("99999");

        // Assert
        assertNull(student, "Student should be null.");
    }

    // Test 4: TestDeleteStudent
    @Test
    public void testDeleteStudent() {
        // Arrange
        String studentId = "12345";
        studentManager.saveStudent(studentId, "John Doe", 20, "johndoe@example.com", "Computer Science");

        // Act
        studentManager.deleteStudent(studentId);
        Student student = studentManager.searchStudent(studentId);

        // Assert
        assertNull(student, "Student should be null after deletion.");
    }

    // Test 5: TestDeleteStudent_StudentNotFound
    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Act
        studentManager.deleteStudent("99999");
        Student student = studentManager.searchStudent("99999");

        // Assert
        assertNull(student, "Student should be null since it was not found.");
    }

    // Test 6: TestStudentAge_StudentAgeValid
    @Test
    public void testStudentAge_StudentAgeValid() {
        // Arrange
        String studentId = "12345";
        int validAge = 20;

        // Act
        boolean isAgeValid = studentManager.setStudentAge(studentId, validAge);

        // Assert
        assertTrue(isAgeValid, "The student's age should be valid.");
        Student student = studentManager.searchStudent(studentId);
        assertNotNull(student, "Student should not be null.");
        assertEquals(validAge, student.getAge());
    }

    // Test 7: TestStudentAge_StudentAgeInvalid
    @Test
    public void testStudentAge_StudentAgeInvalid() {
        // Arrange
        String studentId = "12345";
        int invalidAge = 15;  // Assuming valid age is 16 or older

        // Act
        boolean isAgeValid = studentManager.setStudentAge(studentId, invalidAge);

        // Assert
        assertFalse(isAgeValid, "The student's age should be invalid.");
        Student student = studentManager.searchStudent(studentId);
        assertNotNull(student, "Student should not be null.");
        assertNotEquals(invalidAge, student.getAge(), "The age should not be set to invalid age.");
    }

    // Test 8: TestStudentAge_StudentAgeInvalidCharacter
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        // Arrange
        String studentId = "12345";
        String invalidAge = "twenty";  // Non-numeric input

        // Act & Assert
        assertThrows(NumberFormatException.class, () -> {
            studentManager.setStudentAge(studentId, Integer.parseInt(invalidAge));
        }, "Setting age with non-numeric input should throw NumberFormatException.");
    }
}
