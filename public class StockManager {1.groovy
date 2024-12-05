public class StockManager {
    public static void main(String[] args) {
        // Step 1: Define the arrays
        int[] stockLevels = new int[10]; // Array to store stock levels
        double[] prices = new double[10]; // Array to store prices

        // Step 2: Initialize the arrays with sample data
        stockLevels[0] = 50; prices[0] = 19.99; // Product 1
        stockLevels[1] = 30; prices[1] = 29.99; // Product 2
        stockLevels[2] = 20; prices[2] = 9.99;  // Product 3
        stockLevels[3] = 15; prices[3] = 49.99; // Product 4
        stockLevels[4] = 10; prices[4] = 99.99; // Product 5
        stockLevels[5] = 25; prices[5] = 15.99; // Product 6
        stockLevels[6] = 40; prices[6] = 5.99;  // Product 7
        stockLevels[7] = 60; prices[7] = 39.99; // Product 8
        stockLevels[8] = 5;  prices[8] = 199.99; // Product 9
        stockLevels[9] = 12; prices[9] = 79.99; // Product 10

        // Step 3: Calculate total value for each product and overall total value
        double totalValue = 0.0;

        System.out.println("Product Stock Levels and Total Values:");
        for (int i = 0; i < stockLevels.length; i++) {
            double productValue = stockLevels[i] * prices[i]; // Calculate total value for each product
            totalValue += productValue; // Accumulate total value
            System.out.printf("Product %d: Stock = %d, Price = %.2f, Total Value = %.2f%n", 
                              (i + 1), stockLevels[i], prices[i], productValue);
        }

        // Display the overall total value of all products
        System.out.printf("Overall Total Value of Stock: %.2f%n", totalValue);
    }
}
