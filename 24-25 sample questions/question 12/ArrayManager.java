import java.util.Scanner;

public class ArrayManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: Specify the number of elements
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        // Step 2: Create an array to hold the integers
        int[] numbers = new int[n];

        // Step 3: Input integer values
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Step 4: Display the array
        System.out.print("You entered: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Step 5: Compute the sum and average
        int sum = 0;
        int largest = numbers[0];
        int smallest = numbers[0];

        for (int number : numbers) {
            sum += number;
            if (number > largest) {
                largest = number;
            }
            if (number < smallest) {
                smallest = number;
            }
        }

        double average = (double) sum / n;

        // Step 6: Display sum, average, largest, and smallest
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Largest: " + largest);
        System.out.println("Smallest: " + smallest);

        // Step 7: Search for a specific integer
        System.out.print("Enter an integer to search for: ");
        int searchValue = scanner.nextInt();
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (numbers[i] == searchValue) {
                index = i;
                break;
            }
        }

        // Step 8: Display search results
        if (index != -1) {
            System.out.println("Integer " + searchValue + " found at index: " + index);
        } else {
            System.out.println("Integer " + searchValue + " not found in the array.");
        }

        // Close the scanner
        scanner.close();
    }
}
