public class TemperatureTracker {
    public static void main(String[] args) {
        // Step 1: Initialize the temperature data for 3 cities over 7 days
        double[][] temperatures = {
            {72.5, 75.0, 78.0, 74.5, 73.0, 76.5, 77.0}, // City 1
            {68.0, 70.5, 69.0, 71.0, 72.0, 70.0, 71.5}, // City 2
            {80.0, 82.5, 81.0, 79.5, 78.0, 77.5, 80.0}  // City 3
        };

        // Step 2: Calculate average temperature for each city
        for (int i = 0; i < temperatures.length; i++) {
            double sum = 0;
            for (int j = 0; j < temperatures[i].length; j++) {
                sum += temperatures[i][j];
            }
            double average = sum / temperatures[i].length;
            System.out.printf("Average temperature for City %d: %.2f%n", (i + 1), average);
        }

        // Step 3: Find highest and lowest temperatures for each city
        for (int i = 0; i < temperatures.length; i++) {
            double highest = temperatures[i][0];
            double lowest = temperatures[i][0];
            for (int j = 1; j < temperatures[i].length; j++) {
                if (temperatures[i][j] > highest) {
                    highest = temperatures[i][j];
                }
                if (temperatures[i][j] < lowest) {
                    lowest = temperatures[i][j];
                }
            }
            System.out.printf("City %d - Highest: %.2f, Lowest: %.2f%n", (i + 1), highest, lowest);
        }
    }
}
