import java.util.*;

public class Main {

    // Method to remove duplicates from an ArrayList (Part A)
    public static ArrayList<Integer> removeDuplicates(List<Integer> list) {
        LinkedHashSet<Integer> uniqueSet = new LinkedHashSet<>(list);
        return new ArrayList<>(uniqueSet);
    }

    // Various operations on ArrayList (Part B)
    public static void arrayListOperations(int choice, ArrayList<Integer> numbers) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                // Check if an element exists
                System.out.print("Enter element to check: ");
                int elementToCheck = scanner.nextInt();
                boolean exists = numbers.contains(elementToCheck);
                System.out.println("Does element " + elementToCheck + " exist? " + exists);
                break;
                
            case 2:
                // Add element at a particular index
                System.out.print("Enter element to add: ");
                int elementToAdd = scanner.nextInt();
                System.out.print("Enter index to add element: ");
                int indexToAdd = scanner.nextInt();
                numbers.add(indexToAdd, elementToAdd);
                System.out.println("After adding element: " + numbers);
                break;
                
            case 3:
                // Remove element at a particular index
                System.out.print("Enter index to remove element: ");
                int indexToRemove = scanner.nextInt();
                numbers.remove(indexToRemove);
                System.out.println("After removing element: " + numbers);
                break;

            case 4:
                // Sort the ArrayList
                Collections.sort(numbers);
                System.out.println("Sorted ArrayList: " + numbers);
                break;

            case 5:
                // Reverse the ArrayList
                Collections.reverse(numbers);
                System.out.println("Reversed ArrayList: " + numbers);
                break;

            case 6:
                // Compare two ArrayLists
                ArrayList<Integer> anotherList = new ArrayList<>(Arrays.asList(50, 40, 30, 20, 10));
                boolean areEqual = numbers.equals(anotherList);
                System.out.println("Are the two ArrayLists equal? " + areEqual);
                break;

            case 7:
                // Find first and last occurrence of repeated elements
                System.out.print("Enter element to find: ");
                int elementToFind = scanner.nextInt();
                int firstIndex = numbers.indexOf(elementToFind);
                int lastIndex = numbers.lastIndexOf(elementToFind);
                System.out.println("First occurrence of " + elementToFind + ": " + firstIndex);
                System.out.println("Last occurrence of " + elementToFind + ": " + lastIndex);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part A - Removing duplicates from ArrayList
        System.out.println("Part A: Removing duplicates");
        List<Integer> inputList = Arrays.asList(10, 20, 10, 15, 40, 15, 40);
        ArrayList<Integer> uniqueList = removeDuplicates(inputList);
        System.out.println("Unique values: " + uniqueList);

        // Part B - Perform various operations using switch-case
        System.out.println("\nPart B: ArrayList operations");
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 20, 30, 40));

        System.out.println("1. Check if an element exists");
        System.out.println("2. Add element at a particular index");
        System.out.println("3. Remove element at a particular index");
        System.out.println("4. Sort the ArrayList");
        System.out.println("5. Reverse the ArrayList");
        System.out.println("6. Compare two ArrayLists");
        System.out.println("7. Find first and last occurrence of an element");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        arrayListOperations(choice, numbers);

        scanner.close();
    }
}
