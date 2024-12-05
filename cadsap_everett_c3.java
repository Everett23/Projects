package com.mycompany.cadsap_everett_c3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class cadsap_everett_c3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variable to store the number of students and subjects
        int numStudents = 0;
        int numSubjects = 0;

        // Prompt the user to input the number of students with validation
        while (true) {
            System.out.print("Enter the number of students (Minimum 1, maximum 10): ");
            try {
                numStudents = sc.nextInt();

                // Check if the entered number is within the valid range
                if (numStudents >= 1 && numStudents <= 10) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Error: The number of students must be between 1 and 10. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter an integer.");
                sc.next(); // Clear the invalid input
            }
        }

        // Prompt the user to input the number of subjects with validation
        while (true) {
            System.out.print("Enter the number of subjects (Minimum 1, maximum 10): ");
            try {
                numSubjects = sc.nextInt();

                // Check if the entered number is within the valid range
                if (numSubjects >= 1 && numSubjects <= 10) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Error: The number of subjects must be between 1 and 10. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter an integer.");
                sc.next(); // Clear the invalid input
            }
        }

        // Initialize a 2D array to store grades for each student across subjects
        double[][] studentGrades = new double[numStudents][numSubjects];

        // Arrays to store student names and subject names
        String[] studentNames = new String[numStudents];
        String[] subjectNames = new String[numSubjects];
        
        // Ask user to input each subject name
        sc.nextLine(); // Consume the newline character
        for (int s = 0; s < numSubjects; s++) {
            System.out.print("Enter name for Subject " + (s + 1) + ": ");
            subjectNames[s] = sc.nextLine();
        }

        // Loop to collect student names and their grades for each subject
        for (int x = 0; x < numStudents; x++) {
            System.out.print("Enter name for Student " + (x + 1) + ": ");
            studentNames[x] = sc.nextLine(); // Store student name

            // Inner loop to collect grade data for each subject for the current student
            for (int y = 0; y < studentGrades[x].length; y++) {
                System.out.print("Enter grade for " + subjectNames[y] + ": ");
                
                try {
                    double grade = sc.nextDouble();

                    // Check if the grade is within the acceptable range (0 to 100)
                    if (grade >= 70 && grade <= 99) {
                        studentGrades[x][y] = grade; // Store valid grade
                    } else {
                        System.out.println("Error: Grade must be between 70 and 99. Please try again.");
                        y--; // Decrement y to repeat the input for the same subject
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Invalid grade. Please enter a number.");
                    y--; // Decrement y to repeat the input for the same subject
                    sc.next(); // Clear the invalid input
                }
            }
            sc.nextLine(); // Consume the newline character after grades input
        }

        // Print headers for displaying student grades and averages with improved alignment
        System.out.println("\nGrade Report:\n");
        System.out.printf("%-20s", "Student Name");

        // Adjust the subject column width for better spacing
        int subjectColumnWidth = 15;
        for (String subject : subjectNames) {
            System.out.printf("%-" + subjectColumnWidth + "s", subject);
        }
        System.out.println("Average");

        // Calculate and display each student's average grade and individual grades
        for (int x = 0; x < numStudents; x++) {
            double sum = 0;

            // Print the student's name, left-aligned in its column
            System.out.printf("%-20s", studentNames[x]);

            // Print each subject's grade with adjusted spacing and calculate the sum
            for (int y = 0; y < studentGrades[x].length; y++) {
                System.out.printf("%-" + subjectColumnWidth + ".2f", studentGrades[x][y]);
                sum += studentGrades[x][y];
            }

            // Calculate the average grade
            double average = sum / numSubjects;

            // Print the average grade for the student with the same column width as subjects
            System.out.printf("%-" + subjectColumnWidth + ".2f%n", average);
        }

        // Close the Scanner 
        sc.close();
    }
}