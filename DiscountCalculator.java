import java.util.Scanner;

public class DiscountCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for the total purchase amount
        System.out.print("Enter the total purchase amount in PHP: ");
        double totalAmount = scanner.nextDouble();
        
        // Discount variables
        double discountRate = 0.0;
        double discountAmount = 0.0;
        double finalPrice = 0.0;

        // Determine the discount rate based on the total amount
        if (totalAmount < 1000) {
            discountRate = 0.0; // No discount
        } else if (totalAmount >= 1000 && totalAmount <= 5000) {
            discountRate = 0.05; // 5% discount
        } else if (totalAmount > 5000 && totalAmount <= 10000) {
            discountRate = 0.10; // 10% discount
        } else {
            discountRate = 0.15; // 15% discount
        }

        // THIS WILL THE DISCOUNT AMOUNT 
        discountAmount = totalAmount * discountRate;
        finalPrice = totalAmount - discountAmount;

        // THIS WILL DISPLAY THE RESULT
        System.out.printf("Discount Amount: %.2f PHP%n", discountAmount);
        System.out.printf("Final Price: %.2f PHP%n", finalPrice);
        
        // Close the scanner
        scanner.close();
    }
}
