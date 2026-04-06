import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// Bogie Class
class Bogie {
    private String id;
    private String name;
    private int capacity;
    private String cargo;

    public Bogie(String id, String name, int capacity, String cargo) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.cargo = cargo;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String getCargo() { return cargo; }

    @Override
    public String toString() {
        return String.format("[%s | %s | Cap: %d]", id, name, capacity);
    }
}

public class TrainConsistManagementApp {

    private static List<Bogie> bogieList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management System ===\n");

        // Adding a larger dataset to make performance difference visible
        for (int i = 0; i < 1000; i++) {
            addBogieData("B" + i, (i % 2 == 0 ? "Sleeper" : "AC Chair"), (i % 100), "None");
        }

        // Run previous logic if needed, then performance test
        comparePerformance();
    }

    private static void addBogieData(String id, String name, int capacity, String cargo) {
        bogieList.add(new Bogie(id, name, capacity, cargo));
    }

    // --- UC13: Performance Comparison Logic ---
    private static void comparePerformance() {
        System.out.println("=== UC13: Performance Comparison (Loops vs Streams) ===");

        // 1. Benchmark: Traditional Loop
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.getCapacity() > 50) {
                loopFiltered.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // 2. Benchmark: Stream API
        long startTimeStream = System.nanoTime();
        List<Bogie> streamFiltered = bogieList.stream()
                .filter(b -> b.getCapacity() > 50)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // Display Results
        System.out.println("Loop Execution Time   : " + durationLoop + " ns");
        System.out.println("Stream Execution Time : " + durationStream + " ns");

        if (durationLoop < durationStream) {
            System.out.println("Result: Traditional Loop was faster by " + (durationStream - durationLoop) + " ns");
        } else {
            System.out.println("Result: Stream API was faster by " + (durationLoop - durationStream) + " ns");
        }
        System.out.println("Total items filtered: " + loopFiltered.size());
    }
}