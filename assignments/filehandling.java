package assignments;
import java.util.*;
import java.io.*;

public class filehandling {
    
   
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
   

    public static void writeFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    

    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
    
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Enter file name (with extension, e.g., example.txt): ");
        String fileName = scanner.nextLine();
        
       
        createFile(fileName);

       
        System.out.println("Enter content to write to the file: ");
        String content = scanner.nextLine();
        writeFile(fileName, content);

        
        System.out.println("Reading the file content:");
        readFile(fileName);
        
        scanner.close();
    }
 }
