import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System ===\n");

        // UC19: Binary Search for Bogie ID
        String[] bogieIds = {"B105", "B101", "B106", "B102", "B104", "B103"};
        String searchKey = "B104";

        System.out.println("--- UC19: Binary Search (Optimized) ---");

        // PRECONDITION: Data must be sorted for Binary Search to work
        Arrays.sort(bogieIds);
        System.out.println("Sorted IDs for Search: " + Arrays.toString(bogieIds));
        System.out.println("Searching for: " + searchKey);

        // Perform Binary Search
        int resultIndex = performBinarySearch(bogieIds, searchKey);

        if (resultIndex != -1) {
            System.out.println("✅ Success: Bogie " + searchKey + " found at sorted index " + resultIndex);
        } else {
            System.out.println("❌ Error: Bogie " + searchKey + " not found.");
        }

        System.out.println("\nProgram continues execution safely...");
    }

    /**
     * UC19: Binary Search Implementation
     * Strategy: Divide and Conquer
     * Time Complexity: O(log n)
     */
    private static int performBinarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Find the middle index
            int mid = low + (high - low) / 2;

            // Compare key with middle element using compareTo()
            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                return mid; // Found it!
            } else if (comparison > 0) {
                low = mid + 1; // Key is in the right half
            } else {
                high = mid - 1; // Key is in the left half
            }
        }
        return -1; // Exhausted search range, not found
    }
}