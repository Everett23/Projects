package com.mycompany.cadsapeverett;

import java.util.Scanner;

public class cadsapeverett {

    public static void main(String[] args) {
        Scanner newScanner = new Scanner(System.in);
        
        // Use 3 arrays
        int[] productStock = new int[10];
        double[] productPrice = new double[10];
        double[] totalValue = new double[10];
        
        // Ask for User Input for Quantity Numbers, loop for 10x
        for (int i = 0; i < productStock.length; i++) {
            System.out.print("Enter Stock Level (Quantity) for item " + (i + 1) + ": ");
            int userInput = newScanner.nextInt();
            
            // Error Handling for negative, zero, and overly large values
            if (userInput > 0 && userInput <= 1000) {  // assuming 1000 is the reasonable limit
                productStock[i] = userInput;
            } else if (userInput == 0) {
                System.out.println("Quantity cannot be zero. Please enter a valid quantity.");
                i--;  // retry for current item
            } else if (userInput < 0) {
                System.out.println("Invalid Quantity. Enter a non-negative value.");
                i--;  // retry for current item
            } else {
                System.out.println("Quantity too large. Enter a value under 1000.");
                i--;  // retry for current item
            }
        }    
        
        // Ask for User Input for Pricing of Products, loop for 10x
        for (int e = 0; e < productPrice.length; e++) {
            System.out.print("Enter Stock Price for item " + (e + 1) + ": ");
            double userPrice = newScanner.nextDouble();
        
            // Error Handling for negative, zero, and overly large prices
            if (userPrice > 0 && userPrice <= 10000) {  // assuming 10000 is the reasonable price limit
                productPrice[e] = userPrice;
            } else if (userPrice == 0) {
                System.out.println("Price cannot be zero. Please enter a valid price.");
                e--;  // retry for current item
            } else if (userPrice < 0) {
                System.out.println("Invalid Pricing. Enter a non-negative value.");
                e--;  // retry for current item
            } else {
                System.out.println("Price too high. Enter a value under 10000.");
                e--;  // retry for current item
            }
        }
        
        // Define Total Value for storing the sum of all product values
        double finalTotalValue = 0;
                
        // Store the values of productValue after formula use, 
        for (int x = 0; x < 10; x++) {
            // Formula for total value
            totalValue[x] = productStock[x] * productPrice[x];
            
            // Sum of all total values of item 1-10
            finalTotalValue += totalValue[x];
        }   
        
        // Check if any product was entered with zero value 
        if (finalTotalValue == 0) {
            System.out.println("All entered values result in a zero total. Please check inputs.");
        } else {
            // Median, Top, and Lowest total values
            double average = finalTotalValue / 10;
            double highest = totalValue[0];
            double lowest = totalValue[0];
                    
            // Calculate Low and Highest total value
            for (int y = 0; y < 10; y++) {
                if (totalValue[y] > highest) {
                    highest = totalValue[y];
                }
                if (totalValue[y] < lowest) {
                    lowest = totalValue[y];
                }
            }
            
            System.out.printf("\nQuantity\t\tPrice\t\t\tProduct Value%n");
            
            for (int z = 0; z < 10; z++) {
                System.out.printf("%s\t\t\t$ %.2f\t\t\t$ %.2f%n", productStock[z], productPrice[z], totalValue[z]);
            }
            
            // Total Value, Average, Highest, and Lowest values
            System.out.printf("\nFinal Product Value:   $ %.2f%n", finalTotalValue);
            System.out.printf("Average Product Value: $ %.2f%n", average);
            System.out.printf("Highest Product Value: $ %.2f%n", highest);
            System.out.printf("Lowest Product Value:  $ %.2f%n", lowest);
        }
        
        newScanner.close();  // Close the Scanner to prevent leakage
    }     
}