public class BinarySearchRecursive {

    // Recursive binary search
    public static int binarySearch(int[] arr, int key, int left, int right) {
        if (left > right) {
            return -1; // Base case: Element not found
        }
        
        int mid = left + (right - left) / 2; // Calculate the middle index

        // Check if the key is at the middle
        if (arr[mid] == key) {
            return mid;
        }

        // If key is greater, search the right half
        if (arr[mid] < key) {
            return binarySearch(arr, key, mid + 1, right);
        } else {
            // If key is smaller, search the left half
            return binarySearch(arr, key, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        int key = 50;

        int result = binarySearch(arr, key, 0, arr.length - 1);
        
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
