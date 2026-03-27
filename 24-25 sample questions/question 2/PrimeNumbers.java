//package 24-25 sample questions.question 2;

import java.util.Scanner;

public class PrimeNumbers {

    // Method to check if a number is prime
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;  // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;  // If divisible by any number other than 1 and itself, not prime
            }
        }
        return true;
    }

    // Method to print all prime numbers up to a given limit
    public void printPrimesUpTo(int limit) {
        System.out.println("Prime numbers up to " + limit + ":");
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimeNumbers primes = new PrimeNumbers();
        
        // Take user input
        System.out.print("Enter a number: ");
        int limit = scanner.nextInt();
        
        // Print prime numbers up to the input limit
        primes.printPrimesUpTo(limit);
        
        scanner.close();
    }
}
