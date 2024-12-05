package com.mycompany.cadsap_everett;

// Import  classes for handling user input and errors
import java.util.InputMismatchException;
import java.util.Scanner;

public class cadsap_everett {

    public static void main(String[] args) {
        // Initialize a Scanner to receive input from the user
        Scanner newScanner = new Scanner(System.in);

        // Variable to track if input is valid
        boolean validInput = false;

        // Initialize the temperatures data for 3 cities across 7 days
        double[][] cityTemperature = new double[3][7];

        // Arrays to store day names and city names
        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] cityNames = new String[3];

        // Loop to collect city names and their daily temperatures
        for (int x = 0; x < cityTemperature.length; x++) {
            // Prompt user to input each city's name
            System.out.print("Input name for City " + (x + 1) + ": ");
            cityNames[x] = newScanner.nextLine(); // Store city name

            // Inner loop to Calculate average temperature for each city
            for (int y = 0; y < cityTemperature[x].length; y++) {
                System.out.print("Input temperature for " + dayNames[y] + ": ");
                
                try {
                    // Read the temperature value for the day
                    double userTemps = newScanner.nextDouble();

                    // Check if the temperature is within the acceptable range
                    if (userTemps >= -50.00 && userTemps <= 50.00) {
                        cityTemperature[x][y] = userTemps; // Store valid temperature
                        validInput = true; // Mark input as valid
                    } else {
                        // Print an error if the temperature is out of range and repeat input for this day
                        System.out.println("Limit of temperature is -50°Celsius to 50°Celsius, please try again.");
                        y--; // Decrement y to repeat the input for the same day
                    }
                } catch (InputMismatchException e) {
                    // Catch invalid input (non-numeric) and prompt the user again
                    System.out.println("That's not a Valid Number. Try Again.");
                    y--; // Decrement y to repeat the input for the same day
                    newScanner.next(); // Clear the invalid input
                }
            }
            newScanner.nextLine(); // Move to the next line after reading temperatures for one city
        }

        // Print a formatted table of temperature data for each city
        System.out.println("\nTemperature Data:\n");
        System.out.print("City Names:"); // Print header for city names
        for (int i = 0; i < dayNames.length; i++) {
            System.out.printf("%-15s      ", dayNames[i]); // Adjust width to align headers
        }
        System.out.println();

        // Print each city's name and corresponding temperatures for each day
        for (int x = 0; x < cityTemperature.length; x++) {
            System.out.print(cityNames[x]); // Print city name
            for (int y = 0; y < cityTemperature[x].length; y++) {
                System.out.printf("%10.2f°C", cityTemperature[x][y]); // Adjust width for temperature values
            }
            System.out.println();
        }

        // Calculate and display average, highest, and lowest temperatures for each city
        for (int x = 0; x < cityTemperature.length; x++) {
            double sum = 0; // Sum to calculate average
            double highest = -50; // Initialize highest temperature with lowest possible limit
            double lowest = 50; // Initialize lowest temperature with highest possible limit

            // Calculate sum, highest, and lowest temperatures for the city
            for (int y = 0; y < cityTemperature[x].length; y++) {
                sum += cityTemperature[x][y]; // Add temperature to the sum
                if (cityTemperature[x][y] > highest) {
                    highest = cityTemperature[x][y]; // Update to highest if the current temp is greater
                }
                if (cityTemperature[x][y] < lowest) {
                    lowest = cityTemperature[x][y]; // Update to lowest if the current temp is lower
                }
            }

            // Calculate the average temperature by dividing the sum by the number of days
            double average = sum / cityTemperature[x].length;

            // Print the summary for each city with average, highest, and lowest temperatures
            System.out.printf("\n%-15s:      Average: %6.2f°C, Highest: %6.2f°C, Lowest: %6.2f°C%n", cityNames[x], average, highest, lowest);
        }

        // Close the Scanner to release resources
        newScanner.close();
    }
}