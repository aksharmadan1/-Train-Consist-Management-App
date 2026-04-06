import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System ===");

        // UC16: Bubble Sort for Passenger Bogie Capacities
        int[] capacities = {72, 40, 24, 90, 18, 54};

        System.out.println("\n=== UC16: Sorting Bogie Capacities (Bubble Sort) ===");
        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        performBubbleSort(capacities);

        System.out.println("Sorted Capacities  : " + Arrays.toString(capacities));
        System.out.println("\nProgram continues execution safely...");
    }

    /**
     * UC16: Implementation of the Bubble Sort Algorithm
     * Time Complexity: O(n^2)
     */
    private static void performBubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for adjacent comparisons
            // (n - 1 - i) because the last i elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap logic using a temporary variable
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }
}