import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System ===\n");

        // UC16: Data for Sorting
        int[] bogieCapacities = {72, 40, 24, 90, 18, 54};

        System.out.println("--- UC16: Bubble Sort Algorithm ---");
        System.out.println("Original Capacities: " + Arrays.toString(bogieCapacities));

        // Perform the manual sort
        bubbleSort(bogieCapacities);

        System.out.println("Sorted Capacities  : " + Arrays.toString(bogieCapacities));
        System.out.println("\nProgram continues execution safely...");
    }

    /**
     * UC16: Bubble Sort Implementation
     * Note: We avoid using Arrays.sort() here to learn the logic.
     */
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for the number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for adjacent comparisons
            // (n - 1 - i) prevents checking elements that are already bubbled to the end
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // SWAPPING LOGIC
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true; // Mark that a change happened
                }
            }

            // OPTIMIZATION: If no two elements were swapped, array is already sorted
            if (!swapped) break;
        }
    }
}