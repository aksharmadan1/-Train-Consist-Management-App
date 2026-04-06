import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System ===\n");

        // UC17: Sorted Bogie Names (from previous task)
        String[] bogieIds = {"B101", "B105", "B103", "B102", "B104", "B106"};

        System.out.println("--- UC18: Linear Search for Bogie ID ---");
        String searchKey = "B103";
        System.out.println("Searching for Bogie ID: " + searchKey);

        // Perform the search
        int resultIndex = performLinearSearch(bogieIds, searchKey);

        if (resultIndex != -1) {
            System.out.println("✅ Success: Bogie " + searchKey + " found at index " + resultIndex);
        } else {
            System.out.println("❌ Error: Bogie " + searchKey + " not found in the train consist.");
        }

        System.out.println("\nProgram continues execution safely...");
    }

    /**
     * UC18: Linear Search Implementation
     * Time Complexity: O(n)
     */
    private static int performLinearSearch(String[] arr, String key) {
        // Sequential Traversal: Visit elements from start to end
        for (int i = 0; i < arr.length; i++) {
            // Equality Comparison: Use .equals() for String objects
            if (arr[i].equals(key)) {
                return i; // Early Termination: Stop as soon as match is found
            }
        }
        return -1; // Return -1 if the key is not found
    }
}