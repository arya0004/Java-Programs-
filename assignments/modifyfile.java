package assignments;
import java.io.*;
import java.util.*;

public class modifyfile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name you want to view and modify (with extension, e.g., example.txt): ");
        String fileName = scanner.nextLine();

        try {
            // Read the file
            File file = new File(fileName);
            if (file.exists()) {
                System.out.println("Current file content:");
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    System.out.println(data);
                }
                reader.close();
                
                // Modify (append) the file
                System.out.println("Enter additional content to append to the file: ");
                String newContent = scanner.nextLine();
                
                FileWriter writer = new FileWriter(fileName, true);  // 'true' to append to the file
                writer.write("\n" + newContent);
                writer.close();
                System.out.println("Successfully updated the file.");
            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
