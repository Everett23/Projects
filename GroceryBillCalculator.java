import java.util.Scanner;

public class GroceryBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Item 1
        System.out.print("Enter the price of item 1: ");
        double price1 = scanner.nextDouble();
        System.out.print("Enter the quantity of item 1: ");
        int quantity1 = scanner.nextInt();

        // Input for Item 2
        System.out.print("Enter the price of item 2: ");
        double price2 = scanner.nextDouble();
        System.out.print("Enter the quantity of item 2: ");
        int quantity2 = scanner.nextInt();

        // Input for Item 3
        System.out.print("Enter the price of item 3: ");
        double price3 = scanner.nextDouble();
        System.out.print("Enter the quantity of item 3: ");
        int quantity3 = scanner.nextInt();

        // Calculations
        double totalCost1 = price1 * quantity1;
        double totalCost2 = price2 * quantity2;
        double totalCost3 = price3 * quantity3;

        double subtotal = totalCost1 + totalCost2 + totalCost3;
        double discount = subtotal * 0.05; // this is the 5% discount
        double discountedTotal = subtotal - discount;
        double salesTax = discountedTotal * 0.12; // this is the 12% sales tax
        double finalTotal = discountedTotal + salesTax;

        // Output
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Discount (5%%): -$%.2f%n", discount);
        System.out.printf("Sales Tax (12%%): +$%.2f%n", salesTax);
        System.out.printf("Final Total: $%.2f%n", finalTotal);

        // Close the scanner
        scanner.close();
    }
}
