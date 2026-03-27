import java.util.Arrays;
import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Array Operations");
            System.out.println("2. String Operations");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    arrayOperations(sc);
                    break;
                case 2:
                    stringOperations(sc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
        
        sc.close();
    }

    // Array operations
    public static void arrayOperations(Scanner sc) {
        System.out.println("\nArray Operations:");
        System.out.println("A. Initialize an array with given elements");
        System.out.println("B. Find the sum of all elements");
        System.out.println("C. Find the maximum element");
        System.out.println("D. Find the minimum element");
        System.out.println("E. Sort the array in ascending order");
        System.out.println("F. Reverse the array");
        char choice = sc.next().charAt(0);

        switch (choice) {
            case 'A':
                System.out.println("Enter the size of the array:");
                int n = sc.nextInt();
                int[] arr = new int[n];
                System.out.println("Enter " + n + " elements:");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println("Array initialized: " + Arrays.toString(arr));
                break;

            case 'B':
                System.out.println("Enter elements of the array (space separated):");
                int[] arrSum = getInputArray(sc);
                int sum = 0;
                for (int num : arrSum) {
                    sum += num;
                }
                System.out.println("Sum of all elements: " + sum);
                break;

            case 'C':
                int[] arrMax = getInputArray(sc);
                int max = arrMax[0];
                for (int num : arrMax) {
                    if (num > max) {
                        max = num;
                    }
                }
                System.out.println("Maximum element: " + max);
                break;

            case 'D':
                int[] arrMin = getInputArray(sc);
                int min = arrMin[0];
                for (int num : arrMin) {
                    if (num < min) {
                        min = num;
                    }
                }
                System.out.println("Minimum element: " + min);
                break;

            case 'E':
                int[] arrSort = getInputArray(sc);
                Arrays.sort(arrSort);
                System.out.println("Sorted array: " + Arrays.toString(arrSort));
                break;

            case 'F':
                int[] arrReverse = getInputArray(sc);
                for (int i = 0, j = arrReverse.length - 1; i < j; i++, j--) {
                    int temp = arrReverse[i];
                    arrReverse[i] = arrReverse[j];
                    arrReverse[j] = temp;
                }
                System.out.println("Reversed array: " + Arrays.toString(arrReverse));
                break;

            default:
                System.out.println("Invalid option for array operations.");
        }
    }

    // String operations
    public static void stringOperations(Scanner sc) {
        System.out.println("\nString Operations:");
        System.out.println("A. Concatenate two strings");
        System.out.println("B. Find the length of a string");
        System.out.println("C. Convert a string to uppercase");
        System.out.println("D. Convert a string to lowercase");
        System.out.println("E. Check if a string contains a specific substring");
        System.out.println("F. Replace a substring in a string");
        char choice = sc.next().charAt(0);

        switch (choice) {
            case 'A':
                System.out.println("Enter the first string:");
                sc.nextLine();  // Clear the buffer
                String str1 = sc.nextLine();
                System.out.println("Enter the second string:");
                String str2 = sc.nextLine();
                System.out.println("Concatenated String: " + str1 + str2);
                break;

            case 'B':
                System.out.println("Enter a string:");
                sc.nextLine();  // Clear the buffer
                String strLength = sc.nextLine();
                System.out.println("Length of the string: " + strLength.length());
                break;

            case 'C':
                System.out.println("Enter a string:");
                sc.nextLine();  // Clear the buffer
                String strUpper = sc.nextLine();
                System.out.println("Uppercase string: " + strUpper.toUpperCase());
                break;

            case 'D':
                System.out.println("Enter a string:");
                sc.nextLine();  // Clear the buffer
                String strLower = sc.nextLine();
                System.out.println("Lowercase string: " + strLower.toLowerCase());
                break;

            case 'E':
                System.out.println("Enter the main string:");
                sc.nextLine();  // Clear the buffer
                String mainStr = sc.nextLine();
                System.out.println("Enter the substring to check:");
                String substr = sc.nextLine();
                if (mainStr.contains(substr)) {
                    System.out.println("The string contains the substring.");
                } else {
                    System.out.println("The string does not contain the substring.");
                }
                break;

            case 'F':
                System.out.println("Enter the main string:");
                sc.nextLine();  // Clear the buffer
                String originalStr = sc.nextLine();
                System.out.println("Enter the substring to replace:");
                String oldSubstr = sc.nextLine();
                System.out.println("Enter the new substring:");
                String newSubstr = sc.nextLine();
                String replacedStr = originalStr.replace(oldSubstr, newSubstr);
                System.out.println("Replaced string: " + replacedStr);
                break;

            default:
                System.out.println("Invalid option for string operations.");
        }
    }

    // Helper method to get input array
    public static int[] getInputArray(Scanner sc) {
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
