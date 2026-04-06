import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// UC14: Custom Checked Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) { super(message); }
}

// UC15: Custom Unchecked (Runtime) Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) { super(message); }
}

class Bogie {
    private String id;
    private String name; // Shape/Type: e.g., "Rectangular", "Cylindrical"
    private int capacity;
    private String cargo;

    public Bogie(String id, String name, int capacity, String cargo) throws InvalidCapacityException {
        if (capacity <= 0) throw new InvalidCapacityException("Capacity must be > 0");
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.cargo = cargo;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCargo() { return cargo; }

    // UC15: Logic for Safe Cargo Assignment
    public void assignCargo(String newCargo) {
        System.out.println("Attempting to assign " + newCargo + " to Bogie " + id + " (" + name + ")...");

        try {
            // Business Rule: Petroleum can ONLY go in Cylindrical bogies
            if (newCargo.equalsIgnoreCase("Petroleum") && !name.equalsIgnoreCase("Cylindrical")) {
                throw new CargoSafetyException("SAFETY ALERT: Petroleum cannot be assigned to a " + name + " bogie!");
            }
            this.cargo = newCargo;
            System.out.println("✅ Assignment Successful: " + newCargo);

        } catch (CargoSafetyException e) {
            System.err.println("❌ Catch Block: " + e.getMessage());
        } finally {
            // This always runs
            System.out.println("📝 Finally Block: Assignment process completed for Bogie " + id);
        }
    }

    @Override
    public String toString() {
        return String.format("[%s | %s | Cargo: %s]", id, name, cargo);
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== UC15: Safe Cargo Assignment (try-catch-finally) ===\n");

        try {
            // 1. Create a Rectangular Bogie
            Bogie bogie1 = new Bogie("G401", "Rectangular", 1000, "Coal");

            // 2. Test Invalid Assignment (Should trigger Exception + Finally)
            bogie1.assignCargo("Petroleum");

            System.out.println();

            // 3. Create a Cylindrical Bogie
            Bogie bogie2 = new Bogie("G402", "Cylindrical", 500, "Empty");

            // 4. Test Valid Assignment (Should trigger Finally only)
            bogie2.assignCargo("Petroleum");

        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProgram continues execution safely...");
    }
}