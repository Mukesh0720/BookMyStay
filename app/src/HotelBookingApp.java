/**
 * HotelBookingApp is the entry point of the Hotel Booking Management System.
 *
 * This class demonstrates how a Java application starts execution using the
 * main() method and prints output to the console.
 *
 * It also introduces object-oriented modeling, centralized inventory
 * management using HashMap, and read-only room search.
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

        // UC1: Welcome message
        System.out.println("====================================");
        System.out.println(" Welcome to Hotel Booking System ");
        System.out.println(" Version: v1.0 ");
        System.out.println("====================================");

        // UC3: Centralized Inventory
        RoomInventory inventory = new RoomInventory();

        // UC4: Room Search (Read-only)
        RoomSearchService searchService = new RoomSearchService(inventory);

        // Perform search (only available rooms will be displayed)
        searchService.searchAvailableRooms();

        // End message
        System.out.println("\nApplication terminated.");
    }
}