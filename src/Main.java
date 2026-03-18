import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // =========================
        // UC1 — Initialization
        // =========================
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        // =========================
        // UC2 — ArrayList Operations
        // =========================
        System.out.println("\nAdding passenger bogies...");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("Bogies after addition:");
        System.out.println(trainConsist);

        System.out.println("\nRemoving 'AC Chair'...");
        trainConsist.remove("AC Chair");

        System.out.println("\nChecking if 'Sleeper' exists:");
        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie is present.");
        } else {
            System.out.println("Sleeper bogie is NOT present.");
        }

        System.out.println("\nFinal Train Consist (ArrayList):");
        System.out.println(trainConsist);

        // =========================
        // UC3 — HashSet (Unique IDs)
        // =========================
        System.out.println("\nTracking unique bogie IDs...");

        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("B101");
        bogieIds.add("B102");
        bogieIds.add("B103");
        bogieIds.add("B101"); // duplicate

        System.out.println("Unique Bogie IDs:");
        System.out.println(bogieIds);

        // =========================
        // UC4 — LinkedList Operations
        // =========================
        System.out.println("\nMaintaining ordered train consist using LinkedList...");

        LinkedList<String> linkedTrain = new LinkedList<>();
        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");
        linkedTrain.add("AC");
        linkedTrain.add("Cargo");
        linkedTrain.add("Guard");

        System.out.println("Initial Train:");
        System.out.println(linkedTrain);

        System.out.println("\nInserting 'Pantry Car' at position 2...");
        linkedTrain.add(2, "Pantry Car");

        System.out.println("\nRemoving first and last bogies...");
        linkedTrain.removeFirst();
        linkedTrain.removeLast();

        System.out.println("\nFinal Train Consist (LinkedList):");
        System.out.println(linkedTrain);

        // =========================
        // UC5 — LinkedHashSet (Order + Uniqueness)
        // =========================
        System.out.println("\nMaintaining train formation using LinkedHashSet...");

        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate

        System.out.println("Final Train Formation (No duplicates, ordered):");
        System.out.println(formation);

        // =========================
        // END
        // =========================
        System.out.println("\nProgram is running...");
    }
}