import java.util.*;

public class TrainConsistManagementApp {

    // Our central collection of bogie IDs
    private static List<String> bogieIds = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== UC20: Search Operations with State Validation ===\n");

        // TEST 1: Attempt to search when the list is EMPTY
        try {
            System.out.println("Test 1: Searching an empty train...");
            performSafeSearch("B101");
        } catch (IllegalStateException e) {
            System.err.println("❌ Catch Block: " + e.getMessage());
        }

        System.out.println("\n--- Adding Bogies to the Train ---");
        bogieIds.add("B101");
        bogieIds.add("B105");
        bogieIds.add("B103");

        // TEST 2: Attempt to search when the list has DATA
        try {
            System.out.println("Test 2: Searching a populated train...");
            int index = performSafeSearch("B105");
            System.out.println("✅ Success: Bogie found at index " + index);
        } catch (IllegalStateException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        System.out.println("\nProgram finalized successfully.");
    }

    /**
     * UC20: Safe Search with State Validation
     * This method wraps the search logic with a "Fail-Fast" check.
     */
    private static int performSafeSearch(String key) {
        // 1. STATE VALIDATION (Defensive Programming)
        if (bogieIds.isEmpty()) {
            throw new IllegalStateException("Search Operation Failed: The train consist is empty. Please add bogies first.");
        }

        // 2. SEARCH LOGIC (Linear Search from UC18)
        for (int i = 0; i < bogieIds.size(); i++) {
            if (bogieIds.get(i).equals(key)) {
                return i;
            }
        }
        return -1;
    }
}