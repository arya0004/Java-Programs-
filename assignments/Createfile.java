package assignments;
import java.io.*;
import java.util.*;

public class Createfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name (with extension, e.g., example.txt): ");
        String fileName = scanner.nextLine();
        
        try {
            // Create the file
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // Write to the file
            System.out.println("Enter content to write to the file: ");
            String content = scanner.nextLine();
            
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
