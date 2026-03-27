// Base Class
class BankAccount {
    String accountNumber;
    String accountHolderName;
    double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to calculate interest (generic)
    public double calculateInterest() {
        return balance * 0.03; // Assuming 3% interest for generic accounts
    }

    // Overloaded method to calculate interest based on the given rate
    public double calculateInterest(double rate) {
        return balance * rate / 100;
    }
}

// Derived Class: SavingsAccount
class SavingsAccount extends BankAccount {

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    // Overriding method to provide specific interest rate for savings account
    @Override
    public double calculateInterest() {
        return balance * 0.04; // Assuming 4% interest for savings accounts
    }
}

// Derived Class: CurrentAccount
class CurrentAccount extends BankAccount {

    // Constructor
    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    // Overriding method to provide specific interest rate for current account
    @Override
    public double calculateInterest() {
        return balance * 0.02; // Assuming 2% interest for current accounts
    }
}

// Main Class to demonstrate the application
public class BankApplication {
    public static void main(String[] args) {
        // Creating instances of SavingsAccount and CurrentAccount
        SavingsAccount savings = new SavingsAccount("SA123", "John Doe", 5000);
        CurrentAccount current = new CurrentAccount("CA456", "Jane Smith", 7000);

        // Demonstrating Compile-Time Polymorphism (Method Overloading)
        System.out.println("Savings Account Interest (with default rate): " + savings.calculateInterest());
        System.out.println("Savings Account Interest (with custom rate of 5%): " + savings.calculateInterest(5));

        System.out.println("Current Account Interest (with default rate): " + current.calculateInterest());
        System.out.println("Current Account Interest (with custom rate of 3.5%): " + current.calculateInterest(3.5));

        // Demonstrating Runtime Polymorphism (Method Overriding)
        BankAccount account1 = savings; // Upcasting to BankAccount
        BankAccount account2 = current; // Upcasting to BankAccount

        System.out.println("Calculated Interest for Savings Account (runtime polymorphism): " + account1.calculateInterest());
        System.out.println("Calculated Interest for Current Account (runtime polymorphism): " + account2.calculateInterest());
    }
}
