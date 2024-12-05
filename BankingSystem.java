// Custom Exception for Insufficient Funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Banking System Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal amount exceeds current balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! New balance: $" + balance);
    }

    public double getBalance() {
        return balance;
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        
        try {
            account.withdraw(1200.00); // Attempting to withdraw more than the balance
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
