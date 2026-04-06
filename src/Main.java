import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System ===\n");

        // UC16: Manual Bubble Sort (Previous Task)
        int[] bogieCapacities = {72, 40, 24, 90, 18, 54};
        performBubbleSort(bogieCapacities);
        System.out.println("UC16: Sorted Capacities (Manual): " + Arrays.toString(bogieCapacities));

        // UC17: Library Sorting for Bogie Names
        String[] bogieNames = {"Sleeper", "AC Chair", "General", "First Class", "Pantry", "Luggage"};

        System.out.println("\n--- UC17: Sorting Bogie Names (Arrays.sort) ---");
        System.out.println("Original Names: " + Arrays.toString(bogieNames));

        // Use the built-in Java library method
        Arrays.sort(bogieNames);

        System.out.println("Sorted Names  : " + Arrays.toString(bogieNames));
        System.out.println("\nProgram continues execution safely...");
    }

    // UC16 Method preserved for project history
    private static void performBubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}