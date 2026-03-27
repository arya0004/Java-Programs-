import java.util.Scanner;

// Account Class
class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Synchronized method for depositing money
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " | New Balance: " + balance);
    }

    // Synchronized method for withdrawing money
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Withdrawal failed: Insufficient funds. Current Balance: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Transaction Class
class Transaction implements Runnable {
    private Account account;
    private double amount;
    private String transactionType;

    public Transaction(Account account, double amount, String transactionType) {
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    @Override
    public void run() {
        if (transactionType.equalsIgnoreCase("deposit")) {
            account.deposit(amount);
        } else if (transactionType.equalsIgnoreCase("withdraw")) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid transaction type: " + transactionType);
        }
    }
}

// Bank Simulator Class
public class BankSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create a bank account
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        
        Account account = new Account(accountNumber, initialBalance);
        
        // User input for transactions
        while (true) {
            System.out.print("Enter transaction type (deposit/withdraw) or 'exit' to finish: ");
            String transactionType = scanner.next();
            if (transactionType.equalsIgnoreCase("exit")) {
                break;
            }
            
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            
            // Create and start transaction thread
            Transaction transaction = new Transaction(account, amount, transactionType);
            Thread transactionThread = new Thread(transaction);
            transactionThread.start();
            
            try {
                // Wait for the transaction to complete
                transactionThread.join();
            } catch (InterruptedException e) {
                System.out.println("Transaction interrupted: " + e.getMessage());
            }
        }
        
        // Final account balance
        System.out.println("Final Balance: " + account.getBalance());
        scanner.close();
    }
}
