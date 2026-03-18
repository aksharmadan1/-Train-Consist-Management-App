import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Requirement: Print Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Key Concept: List Interface & ArrayList (Dynamic Initialization)
        // We define the list to hold String objects representing bogies
        List<String> trainConsist = new ArrayList<>();

        // Key Concept: size() method
        // Displaying the initial state before any coaches are added
        int initialBogieCount = trainConsist.size();

        System.out.println("Status: Train consist initialized.");
        System.out.println("Initial Bogie Count: " + initialBogieCount);
        System.out.println("------------------------------------");

        // The foundation is now set for adding bogies in UC2
    }
}