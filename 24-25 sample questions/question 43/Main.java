import java.util.HashSet;
import java.util.Scanner;

class WordCounter {
    // Method to count unique words in a given text
    public int countUniqueWords(String text) {
        // Split the text into words based on whitespace
        String[] words = text.split("\\s+");
        
        // Use a HashSet to store unique words
        HashSet<String> uniqueWords = new HashSet<>();
        
        // Add each word to the HashSet
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());  // Convert to lowercase to ensure uniqueness
        }
        
        // Return the size of the HashSet, which represents the count of unique words
        return uniqueWords.size();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a scanner to take input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Ask the user to enter a text string
        System.out.print("Enter a text string: ");
        String inputText = scanner.nextLine();
        
        // Create an object of WordCounter class
        WordCounter wordCounter = new WordCounter();
        
        // Count the number of unique words
        int uniqueWordCount = wordCounter.countUniqueWords(inputText);
        
        // Display the result
        System.out.println("Number of unique words: " + uniqueWordCount);
        
        // Close the scanner
        scanner.close();
    }
}
