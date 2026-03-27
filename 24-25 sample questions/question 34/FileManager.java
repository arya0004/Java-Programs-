import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Count Lines, Words, and Characters in a File");
        System.out.println("2. Search and Replace a Word in a File");
        System.out.println("3. Exit");

        int choice = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                countFileStats(inputScanner);
                break;
            case 2:
                searchAndReplaceInFile(inputScanner);
                break;
            case 3:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

        inputScanner.close();
    }

    // Method to count lines, words, and characters
    private static void countFileStats(Scanner inputScanner) {
        System.out.print("Enter the filename to read: ");
        String filename = inputScanner.nextLine();
        
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Total lines: " + lineCount);
            System.out.println("Total words: " + wordCount);
            System.out.println("Total characters: " + charCount);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    // Method to search and replace a word in a file
    private static void searchAndReplaceInFile(Scanner inputScanner) {
        System.out.print("Enter the filename to read: ");
        String inputFileName = inputScanner.nextLine();

        System.out.print("Enter the word to search for: ");
        String wordToReplace = inputScanner.nextLine();

        System.out.print("Enter the new word to replace with: ");
        String newWord = inputScanner.nextLine();

        System.out.print("Enter the output filename: ");
        String outputFileName = inputScanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(inputFileName));
             FileWriter writer = new FileWriter(outputFileName)) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String modifiedLine = line.replace(wordToReplace, newWord);
                writer.write(modifiedLine + System.lineSeparator());
            }
            System.out.println("Replaced words and saved to new file: " + outputFileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
