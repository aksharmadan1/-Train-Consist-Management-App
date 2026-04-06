import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// --- UC14: Custom Exception Class ---
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class Bogie {
    private String id;
    private String name;
    private int capacity;
    private String cargo;

    // UC14: Constructor with Validation and Exception
    public Bogie(String id, String name, int capacity, String cargo) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid Capacity: " + capacity + ". Must be greater than 0.");
        }
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

        // UC14: Testing Exception Handling
        System.out.println("=== UC14: Handling Invalid Bogie Capacity ===");

        // 1. Attempt to add a VALID bogie
        try {
            addBogieData("B501", "Sleeper", 72, "None");
            System.out.println("✅ Successfully added Sleeper bogie.");
        } catch (InvalidCapacityException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        // 2. Attempt to add an INVALID bogie (Capacity = 0)
        try {
            addBogieData("B502", "AC Chair", 0, "None");
        } catch (InvalidCapacityException e) {
            System.err.println("❌ Expected Error Caught: " + e.getMessage());
        }

        // 3. Attempt to add an INVALID bogie (Capacity = -10)
        try {
            addBogieData("B503", "General", -10, "None");
        } catch (InvalidCapacityException e) {
            System.err.println("❌ Expected Error Caught: " + e.getMessage());
        }

        System.out.println("\nFinal Bogie List Size: " + bogieList.size());
    }

    // Updated helper method to handle/throw the custom exception
    private static void addBogieData(String id, String name, int capacity, String cargo) throws InvalidCapacityException {
        Bogie bogie = new Bogie(id, name, capacity, cargo);
        bogieList.add(bogie);
    }
}