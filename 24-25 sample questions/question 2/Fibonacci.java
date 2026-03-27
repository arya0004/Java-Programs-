//package 24-25 sample questions.question 2;

import java.util.Scanner;

public class Fibonacci {

    // Non-recursive method to calculate the nth Fibonacci number
    public int fibonacciNonRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        
        int a = 0, b = 1, fibonacci = 0;
        for (int i = 2; i <= n; i++) {
            fibonacci = a + b;
            a = b;
            b = fibonacci;
        }
        return fibonacci;
    }

    // Recursive method to calculate the nth Fibonacci number
    public int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fibonacci fib = new Fibonacci();

        System.out.print("Enter the position n to get the Fibonacci number: ");
        int n = scanner.nextInt();

        // Non-recursive result
        System.out.println("Non-Recursive Fibonacci of " + n + " is: " + fib.fibonacciNonRecursive(n));
        
        // Recursive result
        System.out.println("Recursive Fibonacci of " + n + " is: " + fib.fibonacciRecursive(n));
        
        scanner.close();
    }
}
