package assignments;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DisplayFirstThreeLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name (with extension, e.g., example.txt): ");
        String fileName = scanner.nextLine();

        try {
            File file = new File(fileName);
            if (file.exists()) {
                Scanner reader = new Scanner(file);
                int lineCount = 0;
                
                // Read and display only the first three lines
                while (reader.hasNextLine() && lineCount < 3) {
                    String line = reader.nextLine();
                    System.out.println(line);
                    lineCount++;
                }
                reader.close();
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
