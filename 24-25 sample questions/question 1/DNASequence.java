import java.util.Scanner;

public class DNASequence {

    // Method to find the gene sequence from the input DNA string
    public String findSimpleGene(String dna) {
        // Find the index of the start codon "ATG"
        int startIndex = dna.indexOf("ATG");
        
        // If no start codon is found, return an empty string
        if (startIndex == -1) {
            return "";
        }
        
        // Find the index of the stop codon "TAA" after the start codon
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        
        // If no stop codon is found, return an empty string
        if (stopIndex == -1) {
            return "";
        }
        
        // Check if the length of the substring between "ATG" and "TAA" is a multiple of 3
        if ((stopIndex - startIndex) % 3 == 0) {
            return dna.substring(startIndex, stopIndex + 3);  // Return the gene sequence
        } else {
            return "";  // Return an empty string if the length is not a multiple of 3
        }
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a DNA sequence
        System.out.print("Enter a DNA sequence: "); //DNA-“ AGGAATGTTCCCAATAGTAGACATAAAAGTC”
        String dnaInput = scanner.nextLine();  // Read the input string
        
        // Create an instance of DNASequence to call the findSimpleGene method
        DNASequence dnaSeq = new DNASequence();
        
        // Find and display the gene in the input DNA sequence
        String gene = dnaSeq.findSimpleGene(dnaInput);
        
        // Display the result
        if (gene.isEmpty()) {
            System.out.println("No valid gene found.");
        } else {
            System.out.println("The gene sequence is: " + gene);
        }
        
        // Close the scanner
        //scanner.close();
    }
}

