import java.util.Scanner;

public class FloydsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of rows
        System.out.print("Enter the number of rows for Floyd's Triangle: ");
        int numberOfRows = scanner.nextInt();

        // Initialize the starting number
        int number = 1;

        // Generate Floyd's Triangle
        for (int i = 1; i <= numberOfRows; i++) { // Loop for each row
            for (int j = 1; j <= i; j++) { // Loop to print numbers in the row
                System.out.print(number + " "); // Print the current number
                number++; // Increment the number
            }
            System.out.println(); // Move to the next line after each row
        }

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}
