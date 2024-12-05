// Custom Exception for Invalid Quantity
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

// Shopping Cart Class
class ShoppingCart {
    private int availableStock;

    public ShoppingCart(int availableStock) {
        this.availableStock = availableStock;
    }

    public void addProduct(int quantity) throws InvalidQuantityException {
        if (quantity < 0 || quantity > availableStock) {
            throw new InvalidQuantityException("Invalid product quantity. Please enter a valid quantity.");
        }
        System.out.println("Product added to cart. Quantity: " + quantity);
    }

    public int getAvailableStock() {
        return availableStock;
    }
}

// Main Class
public class OnlineShoppingCart {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(10); // Available stock is 10
        
        try {
            cart.addProduct(4); // Attempting to add more than available stock
        } catch (InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            cart.addProduct(-5); // Attempting to add a negative quantity
        } catch (InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            cart.addProduct(2); // Valid quantity
        } catch (InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
