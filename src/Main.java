import java.util.*;
import java.util.stream.Collectors;

// Bogie Class
class Bogie {
    private String id;
    private String name;
    private int capacity;

    public Bogie(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("[%s | Cap: %d]", id, capacity);
    }
}

public class TrainConsistManagementApp {

    private static List<Bogie> bogieList = new ArrayList<>();
    private static Set<String> uniqueBogieIds = new HashSet<>();
    private static TreeSet<String> orderedBogieIds = new TreeSet<>();
    private static Set<String> insertionOrderIds = new LinkedHashSet<>();
    private static Map<String, Integer> bogieCapacityMap = new HashMap<>();

    public static void main(String[] args) {
        // UC1: Initialize
        System.out.println("=== Train Consist Management System ===\n");

        // UC2 - UC6: Adding Data
        addBogieData("B101", "Sleeper", 72);
        addBogieData("B105", "AC Chair", 40);
        addBogieData("B103", "First Class", 24);
        addBogieData("B102", "General", 90);
        addBogieData("B104", "Sleeper", 72); // Duplicate type for grouping test
        addBogieData("B106", "AC Chair", 40); // Duplicate type for grouping test

        // Previous UC Displays
        displayCollectionStatus();
        sortBogiesByCapacity();      // UC7
        filterHighCapacityBogies(60); // UC8

        // UC9: Grouping by Type
        groupBogiesByType();
    }

    private static void addBogieData(String id, String name, int capacity) {
        Bogie bogie = new Bogie(id, name, capacity);
        bogieList.add(bogie);
        uniqueBogieIds.add(id);
        orderedBogieIds.add(id);
        insertionOrderIds.add(id);
        bogieCapacityMap.put(id, capacity);
    }

    private static void displayCollectionStatus() {
        System.out.println("=== UC3-UC6: Unique & Ordered Data ===");
        System.out.println("Unique IDs: " + uniqueBogieIds);
        System.out.println("Sorted IDs: " + orderedBogieIds + "\n");
    }

    private static void sortBogiesByCapacity() {
        System.out.println("=== UC7: Sorted by Capacity ===");
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        bogieList.forEach(System.out::println);
        System.out.println();
    }

    private static void filterHighCapacityBogies(int threshold) {
        System.out.println("=== UC8: Filtered (Cap > " + threshold + ") ===");
        bogieList.stream()
                .filter(b -> b.getCapacity() > threshold)
                .forEach(System.out::println);
        System.out.println();
    }

    private static void groupBogiesByType() {
        System.out.println("=== UC9: Grouping Bogies by Type (Streams) ===");

        // Use Collectors.groupingBy to create a Map<String, List<Bogie>>
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Display the grouped structure
        groupedBogies.forEach((type, list) -> {
            System.out.println("Category: " + type + " -> " + list);
        });
    }
}