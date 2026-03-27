import java.util.Scanner;

public class HollowSquarePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask the user for the size of the hollow square
        System.out.print("Enter the size of the hollow square (minimum size is 3): ");
        int size = scanner.nextInt();
        
        // Ensure the minimum size is respected
        if (size < 3) {
            System.out.println("Size must be at least 3.");
        } else {
            // Loop for each row
            for (int i = 0; i < size; i++) {
                // Loop for each column
                for (int j = 0; j < size; j++) {
                    // Conditions for printing the border of the square
                    if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                        System.out.print("* "); // Print the border
                    } else {
                        System.out.print("  "); // Print the space inside the hollow square
                    }
                }
                System.out.println(); // Move to the next line after each row
            }
        }
        
        scanner.close(); // Close the scanner
    }
}
