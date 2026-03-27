package assignments;
import java.io.*;
import java.util.*;

public class viewfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name you want to view (with extension, e.g., example.txt): ");
        String fileName = scanner.nextLine();
        
        try {
            // Read the file
            File file = new File(fileName);
            if (file.exists()) {
                Scanner reader = new Scanner(file);
                System.out.println("File content:");
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    System.out.println(data);
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
