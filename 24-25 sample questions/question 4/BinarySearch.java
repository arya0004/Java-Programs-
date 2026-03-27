public class BinarySearch {

    // Non-recursive (iterative) binary search
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // Check if the key is at the middle
            if (arr[mid] == key) {
                return mid;
            }

            // If key is greater, ignore the left half
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                // If key is smaller, ignore the right half
                right = mid - 1;
            }
        }
        return -1; // Return -1 if the element is not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        int key = 50;
        
        int result = binarySearch(arr, key);
        
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
