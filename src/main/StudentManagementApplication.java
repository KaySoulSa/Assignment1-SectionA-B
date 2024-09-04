/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */
public class StudentManagementApplication {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    saveStudent();
                    break;
                case "2":
                    searchStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    studentReport();
                    break;
                case "5":
                    exitStudentApplication();
                    return; // Exit the application
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application.");
    }

    private static void saveStudent() {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();
        int age = getValidAge();
        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, email, course);
        students.add(student);
        System.out.println("Student details have been successfully saved.");
    }

    private static int getValidAge() {
        while (true) {
            System.out.print("Enter the student age: ");
            String input = scanner.nextLine();
            try {
                int age = Integer.parseInt(input);
                if (age >= 16) {
                    return age;
                } else {
                    System.out.println("You have entered an incorrect student age! Please re-enter the student age >>");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect student age! Please re-enter the student age >>");
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter the student id to search: ");
        String id = scanner.nextLine();
        
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with Student Id: " + id + " was not found!");
    }

    private static void deleteStudent() {
        System.out.print("Enter the student id to delete: ");
        String id = scanner.nextLine();
        
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                System.out.print("Are you sure you want to delete student " + id + " from the system? Yes (y) to delete: ");
                String confirmation = scanner.nextLine().toLowerCase();
                if (confirmation.equals("y")) {
                    students.remove(i);
                    System.out.println("Student with Student Id: " + id + " WAS deleted!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("Student with Student Id: " + id + " was not found!");
    }

    private static void studentReport() {
        if (students.isEmpty()) {
            System.out.println("No students to report.");
            return;
        }

        System.out.println("STUDENT REPORT:");
        int count = 1;
        for (Student student : students) {
            System.out.println("STUDENT " + count++);
            System.out.println(student);
            System.out.println();
        }
    }

    private static void exitStudentApplication() {
        System.out.println("Exiting application.");
    }
}


