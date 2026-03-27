package assignments;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DisplayLongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name (with extension, e.g., example.txt): ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            if (file.exists()) {
                Scanner reader = new Scanner(file);
                String longestWord = "";
                
                // Read each line and split into words
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    String[] words = line.split("\\s+");  // Split by spaces or multiple spaces
                    
                    for (String word : words) {
                        if (word.length() > longestWord.length()) {
                            longestWord = word;
                        }
                    }
                }
                reader.close();
                
                if (longestWord.isEmpty()) {
                    System.out.println("The file is empty or contains no valid words.");
                } else {
                    System.out.println("The longest word is: " + longestWord);
                }
            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
