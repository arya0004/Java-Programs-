import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> fruits = new ArrayList<>();

        // User input for adding elements to the ArrayList
        System.out.println("Enter the number of fruits you want to add:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < n; i++) {
            System.out.print("Enter fruit " + (i + 1) + ": ");
            String fruit = scanner.nextLine();
            fruits.add(fruit);
        }

        // a. Traverse using for-loop
        System.out.println("\nUsing for-loop:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }

        // a. Traverse using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // a. Traverse using enhanced for-loop (for-each)
        System.out.println("\nUsing enhanced for-loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // b. Check if an element exists in ArrayList
        System.out.print("\nEnter a fruit to check if it exists: ");
        String checkFruit = scanner.nextLine();
        if (fruits.contains(checkFruit)) {
            System.out.println(checkFruit + " exists in the ArrayList.");
        } else {
            System.out.println(checkFruit + " does not exist in the ArrayList.");
        }

        // c. Add an element at a particular index
        System.out.print("\nEnter a fruit to add: ");
        String newFruit = scanner.nextLine();
        System.out.print("Enter the index at which to add the fruit (0 to " + fruits.size() + "): ");
        int index = scanner.nextInt();

        // Check if the index is valid
        if (index >= 0 && index <= fruits.size()) {
            fruits.add(index, newFruit);
            System.out.println("\nArrayList after adding '" + newFruit + "' at index " + index + ":");
            for (String fruit : fruits) {
                System.out.println(fruit);
            }
        } else {
            System.out.println("Invalid index! Please enter an index between 0 and " + fruits.size());
        }

        scanner.close();
    }
}
