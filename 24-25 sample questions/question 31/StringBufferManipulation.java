import java.util.Scanner;

public class StringBufferManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize a StringBuffer with an existing string
        StringBuffer stringBuffer = new StringBuffer("Hello, World!");

        System.out.println("Initial String: " + stringBuffer.toString());

        // Append a new string
        System.out.print("Enter a string to append: ");
        String appendString = scanner.nextLine();
        stringBuffer.append(appendString);
        System.out.println("After Appending: " + stringBuffer.toString());

        // Reverse the entire string
        stringBuffer.reverse();
        System.out.println("After Reversing: " + stringBuffer.toString());

        // Insert a substring at a specified index
        System.out.print("Enter a substring to insert: ");
        String insertString = scanner.nextLine();
        System.out.print("Enter the index at which to insert: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        stringBuffer.insert(index, insertString);
        System.out.println("After Inserting: " + stringBuffer.toString());

        // Replace a part of the string with another substring
        System.out.print("Enter a substring to replace: ");
        String oldSubstring = scanner.nextLine();
        System.out.print("Enter a new substring to replace it with: ");
        String newSubstring = scanner.nextLine();
        int startIndex = stringBuffer.indexOf(oldSubstring);
        if (startIndex != -1) {
            stringBuffer.replace(startIndex, startIndex + oldSubstring.length(), newSubstring);
            System.out.println("After Replacing: " + stringBuffer.toString());
        } else {
            System.out.println("Substring not found for replacement.");
        }

        scanner.close();
    }
}
