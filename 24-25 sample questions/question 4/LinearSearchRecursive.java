public class LinearSearchRecursive {

    // Recursive linear search
    public static int linearSearch(int[] arr, int key, int index) {
        if (index >= arr.length) {
            return -1; // Base case: Reached the end, element not found
        }
        if (arr[index] == key) {
            return index; // Element found, return its index
        }
        return linearSearch(arr, key, index + 1); // Recursive case: Check next element
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 35, 45, 50, 75};
        int key = 45;

        int result = linearSearch(arr, key, 0);
        
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
