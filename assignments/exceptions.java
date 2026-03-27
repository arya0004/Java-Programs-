package assignments;
// import java.util.*;

// public class exceptions {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Divide by zero exception
//         try {
//             int num1 = 10;
//             int num2 = 0;
//             int result = num1 / num2;
//             System.out.println("Result: " + result);
//         } catch (ArithmeticException e) {
//             System.out.println("You shouldn’t divide a number by zero.");
//         }


//         // Arithmetic exception
//         try {
//             System.out.print("Enter a number to divide by zero: ");
//             int num = scanner.nextInt();
//             int result = num / 0;
//             System.out.println("Result: " + result);
//         } catch (ArithmeticException e) {
//             System.out.println("ArithmeticException: You shouldn’t divide a number by zero.");
//         }

//         // Array index out of bounds exception
//         try {
//             int[] array = new int[6];
//             array[7] = 10;  // Trying to access index 7 which does not exist
//         } catch (ArrayIndexOutOfBoundsException e) {
//             System.out.println("ArrayIndexOutOfBoundsException: OOPs!!! Array Index 7 out of bounds for length 6.");
//         }

//         // Null pointer exception
//         try {
//             String str = null;
//             int length = str.length();  // Trying to find the length of a null string
//         } catch (NullPointerException e) {
//             System.out.println("NullPointerException: Null Pointer Exception arises!!");
//         }

//         // Number format exception
//         try {
//             System.out.print("Enter an invalid number (like 'abc'): ");
//             String invalidNumber = scanner.next();
//             int number = Integer.parseInt(invalidNumber);  // Trying to convert invalid string to number
//         } catch (NumberFormatException e) {
//             System.out.println("NumberFormatException: Invalid number format.");
//         }

//         // Interrupted exception
//         try {
//             Thread.sleep(1000);
//             throw new InterruptedException();  // Simulating an interrupt exception
//         } catch (InterruptedException e) {
//             System.out.println("InterruptedException: Thread was interrupted.");
//         }

//         scanner.close();
//     }
// }
