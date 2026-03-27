import java.util.Scanner;

// Task A: Runnable interface implementation
class ThreadExample implements Runnable {
    private String threadName;

    public ThreadExample(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadName + " is running.");
    }
}

// Task B: Bank Account Class
class BankAccount {
    private int balance = 0;

    // Method for depositing money
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Current Balance: " + balance);
    }

    // Method for withdrawing money
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", Current Balance: " + balance);
        } else {
            System.out.println("Insufficient balance to withdraw: " + amount);
        }
    }
}

// Main Class
public class MultiThreadingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Runnable Interface Example");
        System.out.println("2. Bank Account Example");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Runnable Interface Example
                Thread t1 = new Thread(new ThreadExample("Thread-1"));
                Thread t2 = new Thread(new ThreadExample("Thread-2"));
                t1.start();
                t2.start();
                try {
                    t1.join(); // Wait for thread t1 to finish
                    t2.join(); // Wait for thread t2 to finish
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
                break;

            case 2:
                // Bank Account Example
                BankAccount account = new BankAccount();
                // Create deposit and withdraw threads
                Thread depositThread = new Thread(() -> {
                    for (int i = 0; i < 5; i++) {
                        account.deposit(100);
                        try {
                            Thread.sleep(50); // Sleep for 50 milliseconds
                        } catch (InterruptedException e) {
                            System.out.println("Thread interrupted: " + e.getMessage());
                        }
                    }
                });

                Thread withdrawThread = new Thread(() -> {
                    for (int i = 0; i < 5; i++) {
                        account.withdraw(50);
                        try {
                            Thread.sleep(100); // Sleep for 100 milliseconds
                        } catch (InterruptedException e) {
                            System.out.println("Thread interrupted: " + e.getMessage());
                        }
                    }
                });

                // Start the threads
                depositThread.start();
                withdrawThread.start();
                try {
                    depositThread.join(); // Wait for depositThread to finish
                    withdrawThread.join(); // Wait for withdrawThread to finish
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
        
        scanner.close();
    }
}
