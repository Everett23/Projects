import java.util.Scanner;

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuChoice;
        int quantity;
        double totalAmount = 0;

        // Display the menu
        System.out.println("MENU");
        System.out.println("1. Burger    - PHP 100");
        System.out.println("2. Fries     - PHP 50");
        System.out.println("3. Soda      - PHP 30");
        System.out.println("4. Ice Cream - PHP 45");
        System.out.println("5. Exit");

        // User input for menu selection
        System.out.print("Enter the menu number of your choice: ");
        menuChoice = scanner.nextInt();

        // This is the switch statement to process the user's selection
        switch (menuChoice) {
            case 1:
                System.out.print("Enter the quantity: ");
                quantity = scanner.nextInt();
                totalAmount = 100 * quantity;
                System.out.println("You ordered Burger.");
                break;
            case 2:
                System.out.print("Enter the quantity: ");
                quantity = scanner.nextInt();
                totalAmount = 50 * quantity;
                System.out.println("You ordered Fries.");
                break;
            case 3:
                System.out.print("Enter the quantity: ");
                quantity = scanner.nextInt();
                totalAmount = 30 * quantity;
                System.out.println("You ordered Soda.");
                break;
            case 4:
                System.out.print("Enter the quantity: ");
                quantity = scanner.nextInt();
                totalAmount = 45 * quantity;
                System.out.println("You ordered Ice Cream.");
                break;
            case 5:
                System.out.println("Exiting the system.");
                return;
            default:
                System.out.println("Invalid menu number. Please select a number between 1 and 5.");
                return;
        }

        // Display the total bill
        System.out.println("Total amount: " + totalAmount + " PHP");
        scanner.close();
    }
}