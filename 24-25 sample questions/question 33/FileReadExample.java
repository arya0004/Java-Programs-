import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        String inputFile1 = "filename1.txt";
        String inputFile2 = "filename2.txt";

        try (BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
             BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2))) {

            String line1;
            String line2;
            int lineNumber = 1;

            // Read and process both files simultaneously
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                int number = Integer.parseInt(line1); // Read number from the first file
                int square = Integer.parseInt(line2); // Read square from the second file

                // Print the result
                System.out.printf("The square of the no. %d is %d%n", number, square);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the files: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in the files: " + e.getMessage());
        }
    }
}
