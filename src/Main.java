import java.util.*;

// Bogie Class for UC7 (Object-based handling)
class Bogie {
    String id;
    String name;
    int capacity;

    Bogie(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
    public String getId() { return id; }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %-12s | Capacity: %d", id, name, capacity);
    }
}

public class TrainConsistManagementApp {

    // UC2 & UC7: List to store bogie objects
    private static List<Bogie> bogieList = new ArrayList<>();

    // UC3: HashSet for Unique IDs
    private static Set<String> uniqueBogieIds = new HashSet<>();

    // UC4: TreeSet for Ordered IDs
    private static TreeSet<String> orderedBogieIds = new TreeSet<>();

    // UC5: LinkedHashSet for Insertion Order
    private static Set<String> insertionOrderBogies = new LinkedHashSet<>();

    // UC6: HashMap for ID to Capacity Mapping
    private static Map<String, Integer> bogieCapacityMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("--- UC1: Initialize Train Consist ---");
        initializeTrain();

        System.out.println("\n--- UC2 to UC6: Data Processing ---");
        processBogie("B101", "Sleeper", 72);
        processBogie("B105", "AC Chair", 40);
        processBogie("B103", "First Class", 24);
        processBogie("B102", "General", 90);

        displayStatus();

        System.out.println("\n--- UC7: Sort Bogies by Capacity (Comparator) ---");
        sortAndDisplayByCapacity();
    }

    private static void initializeTrain() {
        System.out.println("Train Consist Management System Initialized.");
        System.out.println("Status: Ready for Bogie Assignment.");
    }

    private static void processBogie(String id, String name, int capacity) {
        // UC2: Adding to List
        Bogie newBogie = new Bogie(id, name, capacity);
        bogieList.add(newBogie);

        // UC3: Track Uniqueness
        uniqueBogieIds.add(id);

        // UC4: Maintain Sorted IDs
        orderedBogieIds.add(id);

        // UC5: Maintain Insertion Order
        insertionOrderBogies.add(id);

        // UC6: Mapping ID to Capacity
        bogieCapacityMap.put(id, capacity);
    }

    private static void displayStatus() {
        System.out.println("Unique IDs (HashSet): " + uniqueBogieIds);
        System.out.println("Sorted IDs (TreeSet): " + orderedBogieIds);
        System.out.println("Insertion Order (LinkedHashSet): " + insertionOrderBogies);
        System.out.println("Bogie Capacity Map (HashMap): " + bogieCapacityMap);
    }

    private static void sortAndDisplayByCapacity() {
        // UC7: Using Comparator.comparingInt for sorting
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("Bogies sorted by Seating Capacity (Ascending):");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }
    }
}