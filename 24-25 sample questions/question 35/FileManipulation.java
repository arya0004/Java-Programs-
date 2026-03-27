import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileManipulation {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Reverse Lines and Characters in a File");
        System.out.println("2. Search for a Keyword in a File");
        System.out.println("3. Exit");

        int choice = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                reverseFileContents(inputScanner);
                break;
            case 2:
                searchForKeyword(inputScanner);
                break;
            case 3:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

        inputScanner.close();
    }

    // Method to reverse lines and characters in a file
    private static void reverseFileContents(Scanner inputScanner) {
        System.out.print("Enter the filename to read: ");
        String inputFileName = inputScanner.nextLine();

        System.out.print("Enter the output filename to write reversed content: ");
        String outputFileName = inputScanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(inputFileName));
             FileWriter writer = new FileWriter(outputFileName)) {
            ArrayList<String> lines = new ArrayList<>();

            // Read lines from the input file
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }

            // Write reversed lines with reversed characters to the output file
            for (int i = lines.size() - 1; i >= 0; i--) {
                String reversedLine = new StringBuilder(lines.get(i)).reverse().toString();
                writer.write(reversedLine + System.lineSeparator());
            }

            System.out.println("Reversed lines and characters written to: " + outputFileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to search for a keyword in a file
    private static void searchForKeyword(Scanner inputScanner) {
        System.out.print("Enter the filename to read: ");
        String inputFileName = inputScanner.nextLine();

        System.out.print("Enter the keyword to search for: ");
        String keyword = inputScanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(inputFileName))) {
            boolean found = false;
            int lineNumber = 0;

            // Search for the keyword in each line
            while (fileScanner.hasNextLine()) {
                lineNumber++;
                String line = fileScanner.nextLine();
                if (line.contains(keyword)) {
                    System.out.println("Keyword found in line " + lineNumber + ": " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Keyword not found in the file.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
