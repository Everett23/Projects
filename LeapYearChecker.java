import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for input
        System.out.println("Enter the number of years you want to check:");
        int numberOfYears = scanner.nextInt();
        
        // Array to hold the years
        int[] years = new int[numberOfYears];
        
        // Input years
        System.out.println("Enter the years:");
        for (int i = 0; i < numberOfYears; i++) {
            years[i] = scanner.nextInt();
        }
        
        // Check each year
        for (int year : years) {
            if (isLeapYear(year)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        }
        
        scanner.close();
    }

    // Method to determine if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
