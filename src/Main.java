import java.util.*;
import java.util.stream.Collectors;

// Bogie Class (Used for UC7 & UC8)
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
        return String.format("ID: %s | Name: %-12s | Capacity: %d", id, name, capacity);
    }
}

public class TrainConsistManagementApp {

    // Collections for UC2 to UC6
    private static List<Bogie> bogieList = new ArrayList<>();
    private static Set<String> uniqueBogieIds = new HashSet<>();
    private static TreeSet<String> orderedBogieIds = new TreeSet<>();
    private static Set<String> insertionOrderIds = new LinkedHashSet<>();
    private static Map<String, Integer> bogieCapacityMap = new HashMap<>();

    public static void main(String[] args) {
        // UC1: Initialize
        System.out.println("=== UC1: Initialize Train ===");
        System.out.println("Train Consist Management System Started.\n");

        // UC2 - UC6: Adding Data
        addBogieData("B101", "Sleeper", 72);
        addBogieData("B105", "AC Chair", 40);
        addBogieData("B103", "First Class", 24);
        addBogieData("B102", "General", 90);
        addBogieData("B104", "Sleeper", 72);

        // Display Collection States
        displayCollectionStatus();

        // UC7: Sort by Capacity
        sortBogiesByCapacity();

        // UC8: Filter using Streams
        filterHighCapacityBogies(60);
    }

    private static void addBogieData(String id, String name, int capacity) {
        Bogie bogie = new Bogie(id, name, capacity);

        bogieList.add(bogie);                // UC2: ArrayList
        uniqueBogieIds.add(id);             // UC3: HashSet
        orderedBogieIds.add(id);            // UC4: TreeSet
        insertionOrderIds.add(id);          // UC5: LinkedHashSet
        bogieCapacityMap.put(id, capacity); // UC6: HashMap
    }

    private static void displayCollectionStatus() {
        System.out.println("=== UC3-UC6: Collection Snapshots ===");
        System.out.println("Unique IDs (HashSet): " + uniqueBogieIds);
        System.out.println("Sorted IDs (TreeSet): " + orderedBogieIds);
        System.out.println("Insertion Order (LinkedHashSet): " + insertionOrderIds);
        System.out.println("Capacity Mapping (HashMap): " + bogieCapacityMap + "\n");
    }

    private static void sortBogiesByCapacity() {
        System.out.println("=== UC7: Sorted by Capacity (Comparator) ===");
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));
        bogieList.forEach(System.out::println);
        System.out.println();
    }

    private static void filterHighCapacityBogies(int threshold) {
        System.out.println("=== UC8: Filtering Bogies (Streams) ===");
        System.out.println("Filtering bogies with capacity > " + threshold + "...");

        // Stream Pipeline: Source -> Filter -> Collect
        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No bogies found.");
        } else {
            filtered.forEach(System.out::println);
        }
    }
}