import java.util.Scanner;

public class PascalsTriangle {

    // Method to calculate factorial
    public static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to print Pascal's Triangle
    public static void printPascalsTriangle(int rows) {
        for (int i = 0; i < rows; i++) {
            // Print spaces to center-align the triangle
            for (int j = 0; j < rows - i; j++) {
                System.out.print(" ");
            }
            // Print numbers
            for (int j = 0; j <= i; j++) {
                // Calculate binomial coefficient
                System.out.print(factorial(i) / (factorial(j) * factorial(i - j)) + " ");
            }
            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user for number of rows
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int rows = scanner.nextInt();

        // Call the method to print Pascal's Triangle
        printPascalsTriangle(rows);

        scanner.close();
    }
}
