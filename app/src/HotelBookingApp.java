/**
 * HotelBookingApp is the entry point of the Hotel Booking Management System.
 *
 * This class demonstrates:
 * UC1 - Application start
 * UC2 - Room modeling (OOP)
 * UC3 - Centralized inventory (HashMap)
 * UC4 - Read-only room search
 * UC5 - Booking request queue (FIFO)
 *
 * @author Mukesh
 * @version 1.0
 */
public class HotelBookingApp {

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
        searchService.searchAvailableRooms();

        // UC5: Booking Request Queue (FIFO)
        BookingQueue bookingQueue = new BookingQueue();

        System.out.println("\n--- Adding Booking Requests ---");

        // Simulating guest requests
        bookingQueue.addRequest(new Reservation("Mukesh", "Single Room"));
        bookingQueue.addRequest(new Reservation("Arun", "Double Room"));
        bookingQueue.addRequest(new Reservation("Suresh", "Suite Room"));

        // Display queue (FIFO order)
        bookingQueue.displayQueue();

        // End message
        System.out.println("\nApplication terminated.");
    }
}