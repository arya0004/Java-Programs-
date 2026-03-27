// import java.util.*;

// public class Main {

//     // Method to find 2-digit numbers based on given conditions
//     public static int[] findNumbers(int num1, int num2) {
//         if (num1 >= num2) {
//             System.out.println("Validation failed: num1 should be less than num2.");
//             return new int[0]; // Return an empty array if validation fails
//         }

//         List<Integer> numbers = new ArrayList<>();

//         // Populate all 2-digit positive numbers between num1 and num2
//         for (int i = num1; i <= num2; i++) {
//             if (i >= 10 && i <= 99) { // Check if it's a 2-digit number
//                 int sumOfDigits = (i / 10) + (i % 10); // Sum of digits
//                 if (sumOfDigits % 3 != 0) { // Check if sum of digits is not a multiple of 3
//                     numbers.add(i);
//                 }
//             }
//         }

//         // Convert the list to an array
//         return numbers.stream().mapToInt(i -> i).toArray();
//     }

//     // Method to add two matrices
//     public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
//         int rows = matrixA.length;
//         int cols = matrixA[0].length;

//         // Create a result matrix with the same dimensions
//         int[][] result = new int[rows][cols];

//         // Perform addition
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 result[i][j] = matrixA[i][j] + matrixB[i][j];
//             }
//         }

//         return result;
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Choose an option:");
//         System.out.println("1. Find 2-digit numbers based on conditions");
//         System.out.println("2. Add two matrices");
//         int choice = scanner.nextInt();

//         switch (choice) {
//             case 1:
//                 // Option 1: Find 2-digit numbers
//                 System.out.print("Enter num1: ");
//                 int num1 = scanner.nextInt();
//                 System.out.print("Enter num2: ");
//                 int num2 = scanner.nextInt();

//                 int[] result = findNumbers(num1, num2);
//                 System.out.println("2-digit numbers between " + num1 + " and " + num2 + ":");
//                 for (int number : result) {
//                     System.out.print(number + " ");
//                 }
//                 System.out.println(); // New line after printing numbers
//                 break;

//             case 2:
//                 // Option 2: Add two matrices
//                 System.out.println("Enter the number of rows and columns for the matrices:");
//                 int rows = scanner.nextInt();
//                 int cols = scanner.nextInt();
//                 int[][] matrixA = new int[rows][cols];
//                 int[][] matrixB = new int[rows][cols];

//                 System.out.println("Enter elements for Matrix A:");
//                 for (int i = 0; i < rows; i++) {
//                     for (int j = 0; j < cols; j++) {
//                         matrixA[i][j] = scanner.nextInt();
//                     }
//                 }

//                 System.out.println("Enter elements for Matrix B:");
//                 for (int i = 0; i < rows; i++) {
//                     for (int j = 0; j < cols; j++) {
//                         matrixB[i][j] = scanner.nextInt();
//                     }
//                 }

//                 int[][] resultMatrix = addMatrices(matrixA, matrixB);
//                 System.out.println("Result of matrix addition:");
//                 for (int i = 0; i < resultMatrix.length; i++) {
//                     for (int j = 0; j < resultMatrix[i].length; j++) {
//                         System.out.print(resultMatrix[i][j] + " ");
//                     }
//                     System.out.println(); // New line for each row
//                 }
//                 break;

//             default:
//                 System.out.println("Invalid choice. Please select 1 or 2.");
//         }

//         scanner.close();
//     }
// }
import java.util.*;

public class Main {
    // Constructor (optional in this case)
    public Main() {
    }

    // Method to find 2-digit numbers between num1 and num2
    public static int[] findNumbers(int num1, int num2) {
        // Validate that num1 is less than num2
        if (num1 >= num2) {
            System.out.println("Validation failed: num1 should be less than num2.");
            return new int[0]; // Return an empty array if validation fails
        }

        // Create an ArrayList to store valid numbers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Loop through numbers between num1 and num2
        for (int i = num1; i <= num2; i++) {
            // Check if the number is a 2-digit number
            if (i >= 10 && i <= 99) {
                // Calculate the sum of the digits
                int sumOfDigits = (i / 10) + (i % 10);
                
                // If the sum is not a multiple of 3, add it to the list
                if (sumOfDigits % 3 != 0) {
                    numbers.add(i);
                }
            }
        }

        // Convert ArrayList to array
        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int columns = matrixA[0].length;
        int[][] resultMatrix = new int[rows][columns];

        // Add corresponding elements of the two matrices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return resultMatrix;
    }

    // Main method to test the functionalities
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask the user for an option
        System.out.println("Choose an option:");
        System.out.println("1. Find 2-digit numbers based on conditions");
        System.out.println("2. Add two matrices");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Case 1: Find 2-digit numbers
                System.out.print("Enter num1: ");
                int num1 = scanner.nextInt();
                System.out.print("Enter num2: ");
                int num2 = scanner.nextInt();
                
                // Call the method and store the result
                int[] numbers = findNumbers(num1, num2);
                
                // Print the result
                if (numbers.length > 0) {
                    System.out.println("2-digit numbers between " + num1 + " and " + num2 + ":");
                    for (int number : numbers) {
                        System.out.print(number + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println("No valid numbers found.");
                }
                break;

            case 2:
                // Case 2: Add two matrices
                System.out.println("Enter the number of rows and columns for the matrices:");
                int rows = scanner.nextInt();
                int columns = scanner.nextInt();

                int[][] matrixA = new int[rows][columns];
                int[][] matrixB = new int[rows][columns];

                // Input for Matrix A
                System.out.println("Enter elements for Matrix A:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrixA[i][j] = scanner.nextInt();
                    }
                }

                // Input for Matrix B
                System.out.println("Enter elements for Matrix B:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        matrixB[i][j] = scanner.nextInt();
                    }
                }

                // Call the method to add matrices
                int[][] resultMatrix = addMatrices(matrixA, matrixB);

                // Print the result matrix
                System.out.println("Result of matrix addition:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        System.out.print(resultMatrix[i][j] + " ");
                    }
                    System.out.println();
                }
                break;

            default:
                // If an invalid option is chosen
                System.out.println("Invalid choice. Please select 1 or 2.");
        }

        // Close the scanner
        //scanner.close();
    }
}
