public class LinearSearch {

    // Non-recursive (iterative) linear search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Return the index of the found element
            }
        }
        return -1; // Return -1 if the element is not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 35, 45, 50, 75};
        int key = 45;
        
        int result = linearSearch(arr, key);
        
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
