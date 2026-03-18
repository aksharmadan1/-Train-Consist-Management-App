import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Initialize Train Consist (Dynamic List)
        List<String> trainConsist = new ArrayList<>();

        // Display Initial Bogie Count
        System.out.println("Train initialized successfully.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        // Continue Program
        System.out.println("Program is running...");
    }
}
