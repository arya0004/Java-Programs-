import java.util.ArrayList;
import java.util.Iterator;

public class RemovePrimeNumbers {
    
    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;  // Numbers <= 1 are not prime
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;  // If divisible by any number other than 1 and itself, not prime
            }
        }
        return true;  // Otherwise, it is prime
    }

    public static void main(String[] args) {
        // Create an ArrayList to hold numbers from 1 to 25
        ArrayList<Integer> numbers = new ArrayList<>();
        
        // Adding numbers from 1 to 25 into the ArrayList
        for (int i = 1; i <= 25; i++) {
            numbers.add(i);
        }
        
        // Print the list before removing primes
        System.out.println("Original List: " + numbers);
        
        // Create an Iterator for the ArrayList
        Iterator<Integer> iterator = numbers.iterator();
        
        // Iterate through the list and remove prime numbers
        while (iterator.hasNext()) {
            int num = iterator.next();  // Get the next number
            if (isPrime(num)) {
                iterator.remove();  // Remove the prime number
            }
        }
        
        // Print the list after removing primes
        System.out.println("List after removing prime numbers: " + numbers);
    }
}
