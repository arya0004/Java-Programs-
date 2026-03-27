import java.util.Scanner;

public class NumberTriangle {

    public static void printPattern(int n) {
        // Loop to control the rows
        for (int i = 1; i <= n; i++) {
            // Print spaces to center-align the triangle
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }

            // Print the numbers in each row
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from the user for number of rows
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // Call the method to print the pattern
        printPattern(rows);

        scanner.close();
    }
}
