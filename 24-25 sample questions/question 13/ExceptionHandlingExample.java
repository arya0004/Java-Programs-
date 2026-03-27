import java.io.*;
import java.util.*;

public class ExceptionHandlingExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read data from a file
        System.out.print("Enter the file path to read data from: ");
        String filePath = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            System.out.println("Contents of the file:");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please check the file path.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred while reading the file.");
        }

        // Step 2: Perform arithmetic operations
        boolean continueCalculating = true;
        while (continueCalculating) {
            try {
                System.out.print("Enter two integers for division (space-separated): ");
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                int result = num1 / num2; // Potential ArithmeticException
                System.out.println("Result of division: " + result);
                continueCalculating = false; // Exit loop if division is successful
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero is not allowed.");
                scanner.nextLine(); // Clear invalid input
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter valid integers.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Step 3: Array operations
        int[] numbers = {10, 20, 30};
        System.out.print("Enter an index to access the array (0-2): ");
        try {
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + numbers[index]); // Potential ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. Please enter a valid index.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer for the index.");
            scanner.nextLine(); // Clear invalid input
        }

        // Step 4: NullPointerException example
        String str = null;
        try {
            System.out.println("Length of string: " + str.length()); // Potential NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: Cannot perform operations on a null value.");
        }

        // Close the main scanner
        //scanner.close();
    }
}
