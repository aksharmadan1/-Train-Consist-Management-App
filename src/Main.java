import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // UC1 — Initialization
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        // =========================
        // UC2 — Add Passenger Bogies
        // =========================

        System.out.println("\nAdding passenger bogies...");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        // Display after adding
        System.out.println("Bogies after addition:");
        System.out.println(trainConsist);

        // Remove a bogie
        System.out.println("\nRemoving 'AC Chair'...");
        trainConsist.remove("AC Chair");

        // Check existence
        System.out.println("\nChecking if 'Sleeper' exists:");
        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present.");
        } else {
            System.out.println("Sleeper bogie is NOT present.");
        }

        // Final state
        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);

        System.out.println("\nProgram is running...");
    }
}