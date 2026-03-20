/**
 /**
 * HotelBookingApp is the entry point of the Hotel Booking Management System.
 *
 * This class demonstrates how a Java application starts execution using the
 * main() method and prints output to the console.
 *
 * It also introduces object-oriented modeling and centralized inventory
 * management using HashMap.
 *
 * @author Mukesh
 * @version 1.0
 */
public class HotelBookingApp {

    /**
     * Main method - Entry point of the application.
     *
     * @param args Command line arguments (not used here)
     */
    public static void main(String[] args) {

        // Welcome message (UC1)
        System.out.println("====================================");
        System.out.println(" Welcome to Hotel Booking System ");
        System.out.println(" Version: v1.0 ");
        System.out.println("====================================");

        // UC3: Centralized Inventory
        RoomInventory inventory = new RoomInventory();

        System.out.println("\n--- Room Details & Availability ---");

        // Polymorphism (UC2)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Display details with centralized availability
        single.displayDetails();
        System.out.println("Available: " + inventory.getAvailability("Single Room") + "\n");

        doubleRoom.displayDetails();
        System.out.println("Available: " + inventory.getAvailability("Double Room") + "\n");

        suite.displayDetails();
        System.out.println("Available: " + inventory.getAvailability("Suite Room") + "\n");

        // Display full inventory
        inventory.displayInventory();

        // End message
        System.out.println("\nApplication terminated.");
    }
}