/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Student {
    private final String id;
    private final String name;
    private int age;
    private final String email;
    private final String course;

    // Constructor
    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        setAge(age); // Use setter to validate age
        this.email = email;
        this.course = course;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    // Setter for age with validation
    public void setAge(int age) {
        if (age >= 16) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be 16 or older.");
        }
    }

    @Override
    public String toString() {
        return "STUDENT ID: " + id +
               "\nSTUDENT NAME: " + name +
               "\nSTUDENT AGE: " + age +
               "\nSTUDENT EMAIL: " + email +
               "\nSTUDENT COURSE: " + course;
    }
}

